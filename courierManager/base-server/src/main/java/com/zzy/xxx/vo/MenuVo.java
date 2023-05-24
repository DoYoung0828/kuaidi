package com.zzy.xxx.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Builder
public class MenuVo {

    private static Boolean DISABLED = Boolean.FALSE;

    /**
     * 主键
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 是否禁用
     */
    private Boolean disabled = DISABLED;
}
