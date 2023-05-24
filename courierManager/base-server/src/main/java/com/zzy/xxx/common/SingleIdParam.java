package com.zzy.xxx.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 单个id参数
 * @author xxx
 */
@Getter
@Setter
@ToString(callSuper = true)
public class SingleIdParam extends PageParam {

    @NotNull
    private Long id;
}

