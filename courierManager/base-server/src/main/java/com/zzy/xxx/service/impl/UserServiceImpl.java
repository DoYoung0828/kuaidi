package com.zzy.xxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.xxx.mapper.AdminMenuMapper;
import com.zzy.xxx.mapper.UserInfoMapper;
import com.zzy.xxx.pojo.AdminMenu;
import com.zzy.xxx.pojo.User;
import com.zzy.xxx.mapper.UserMapper;
import com.zzy.xxx.pojo.UserInfo;
import com.zzy.xxx.service.AdminMenuService;
import com.zzy.xxx.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzy.xxx.shiro.AuthJwt;
import com.zzy.xxx.utils.HashUtil;
import com.zzy.xxx.vo.*;
import com.zzy.xxx.web.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

import static com.zzy.xxx.common.GlobalErrorCodeConstants.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2023-04-27
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    private final UserInfoMapper userInfoMapper;
    private final AdminMenuService adminMenuService;

    /**
     * 用户登录，返回token
     *
     * @param param 登录参数
     * @return 结果
     */
    @Override
    public LoginSuccessVo login(LoginParam param) {
        final User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", param.getUsername()));
        if (user == null) {
            throw new ServiceException(USER_NOT_EXIST);
        }
        if (!user.getPassword().equals(HashUtil.createMd5Hash(param.getPassword()))) {
            throw new ServiceException(LOGIN_FAIL);
        }
        if (!user.getEnableFlag()) {
            throw new ServiceException(FORBIDDEN_LOGIN);
        }

        // 修改最后登录时间
        user.setLastLogin(LocalDateTime.now());
        userMapper.updateById(user);

        // 生成token
        final String token = "Bearer " + AuthJwt.createToken
                (Map.of("userId", user.getId()
                        , "roleId", user.getRoleId()
                        , "siteId", Objects.requireNonNullElse(user.getSiteId(), 0)));

        log.info("登录成功，用户名：{}", param.getUsername());

        final LoginSuccessVo loginSuccessVo = new LoginSuccessVo();
        loginSuccessVo.setRoleId(user.getRoleId());
        loginSuccessVo.setToken(token);
        return loginSuccessVo;
    }

    /**
     * 用户注册，生成默认用户信息
     *
     * @param user 注册参数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(User user) {
        if (userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername())) != null) {
            throw new ServiceException(USERNAME_EXIST);
        }
        if (userInfoMapper.selectCount(new QueryWrapper<UserInfo>().eq("phone", user.getPhone())) > 0) {
            throw new ServiceException(PHONE_EXIST);
        }

        user.setPassword(HashUtil.createMd5Hash(user.getPassword()));
        userMapper.insert(user);

        // 若为驿站管理员，生成默认管理员-权限表
        if (1 == user.getRoleId()) {
            final List<AdminMenu> adminMenuList = new ArrayList<>();
            final List<Long> defaultMenuIds = Arrays.asList(1L, 2L);
            defaultMenuIds.forEach(id -> {
                final AdminMenu adminMenu = new AdminMenu();
                adminMenu.setUserId(user.getId());
                adminMenu.setMenuId(id);
                adminMenuList.add(adminMenu);
            });
            adminMenuService.saveBatch(adminMenuList);
        }

        // 生成默认用户信息
        final UserInfo userInfo = new UserInfo();
        userInfo.setPhone(user.getPhone());
        userInfo.setName(user.getName());
        userInfo.setUserId(user.getId());
        if (3 == user.getRoleId()) {
            Random rand = new Random();
            int i = rand.nextInt(999999);
            userInfo.setToken(String.valueOf(i));
        }
        userInfoMapper.insert(userInfo);
    }

    /**
     * 查询首页第一行统计
     *
     * @return 统计结果
     */
    @Override
    public StaticsVo getStatics() {
        return userMapper.getStatics();
    }

    /**
     * 查询近6天的收件派件数
     */
    @Override
    public List<PickStaticsVo> getPickStatics() {
        return userMapper.getPickStatics();
    }

    /**
     * 添加驿站管理员
     *
     * @param adminVo 参数
     */
    @Override
    public void addSiteAdmin(SiteAdminVo adminVo) {
        // 注册用户
        final User user = new User();
        BeanUtils.copyProperties(adminVo, user);
        user.setRoleId(1L);
        register(user);
    }
}
