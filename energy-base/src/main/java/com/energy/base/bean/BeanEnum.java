package com.energy.base.bean;

import lombok.Getter;
import org.modelmapper.ModelMapper;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@Getter
public enum BeanEnum {

    INSTANCE;

    private final ModelMapper modelMapper;

    BeanEnum() {
        this.modelMapper = new ModelMapper();
    }

    public BeanEnum getInstance() {
        return INSTANCE;
    }
}