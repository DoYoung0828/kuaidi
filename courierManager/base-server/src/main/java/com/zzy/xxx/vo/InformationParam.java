package com.zzy.xxx.vo;

import com.zzy.xxx.common.PageParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/17
 */
@Setter
@Getter
@ToString(callSuper = true)
public class InformationParam extends PageParam {

    /**
     * 资讯标题
     */
    private String title;

    /**
     * 资讯分类
     */
    private String type;
}
