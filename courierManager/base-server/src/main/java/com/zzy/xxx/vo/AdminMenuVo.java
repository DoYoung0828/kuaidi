package com.zzy.xxx.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/27
 */
@Setter
@Getter
@ToString
public class AdminMenuVo {

    /**
     * 管理员id
     */
    private Long id;

    /**
     * 待修改菜单id
     */
    private List<Long> menuIds;
}
