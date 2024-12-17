package com.energy.base.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
public enum JacksonEnum {


    INSTANCE;

    private final ObjectMapper objectMapper;

    JacksonEnum() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(JacksonModuleEnum.INSTANCE.getInstance().getSimpleModule());
    }

    public JacksonEnum getInstance() {
        return INSTANCE;
    }

}