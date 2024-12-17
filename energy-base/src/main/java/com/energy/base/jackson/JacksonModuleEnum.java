package com.energy.base.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.Getter;

@Getter
public enum JacksonModuleEnum {


    INSTANCE;

    private final SimpleModule simpleModule;

    JacksonModuleEnum() {
        this.simpleModule = new SimpleModule();

        //序列化设置

        this.simpleModule.addSerializer(java.lang.Long.class, EnergyJacksonSerializer.LONG_SERIALIZER);
        this.simpleModule.addSerializer(java.util.Date.class, EnergyJacksonSerializer.DATE_SERIALIZER);

        this.simpleModule.addSerializer(java.time.Year.class, EnergyJacksonSerializer.YEAR_SERIALIZER);
        this.simpleModule.addSerializer(java.time.YearMonth.class, EnergyJacksonSerializer.YEAR_MONTH_SERIALIZER);
        this.simpleModule.addSerializer(java.time.MonthDay.class, EnergyJacksonSerializer.MONTH_DAY_SERIALIZER);

        this.simpleModule.addSerializer(java.time.LocalDate.class, EnergyJacksonSerializer.LOCAL_DATE_SERIALIZER);
        this.simpleModule.addSerializer(java.time.LocalDateTime.class, EnergyJacksonSerializer.LOCAL_DATE_TIME_SERIALIZER);
        this.simpleModule.addSerializer(java.time.LocalTime.class, EnergyJacksonSerializer.LOCAL_TIME_SERIALIZER);


        //反序列化设置
        this.simpleModule.addDeserializer(java.util.Date.class, EnergyJacksonDeserializer.DATE_DESERIALIZER);

        this.simpleModule.addDeserializer(java.time.Year.class, EnergyJacksonDeserializer.YEAR_DESERIALIZER);
        this.simpleModule.addDeserializer(java.time.YearMonth.class, EnergyJacksonDeserializer.YEAR_MONTH_DESERIALIZER);
        this.simpleModule.addDeserializer(java.time.MonthDay.class, EnergyJacksonDeserializer.MONTH_DAY_DESERIALIZER);

        this.simpleModule.addDeserializer(java.time.LocalDate.class, EnergyJacksonDeserializer.LOCAL_DATE_DESERIALIZER);
        this.simpleModule.addDeserializer(java.time.LocalDateTime.class, EnergyJacksonDeserializer.LOCAL_DATE_TIME_DESERIALIZER);
        this.simpleModule.addDeserializer(java.time.LocalTime.class, EnergyJacksonDeserializer.LOCAL_TIME_DESERIALIZER);


    }

    public JacksonModuleEnum getInstance() {
        return INSTANCE;
    }
}