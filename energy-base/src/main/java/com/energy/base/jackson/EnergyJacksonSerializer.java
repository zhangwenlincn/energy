package com.energy.base.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
public class EnergyJacksonSerializer {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 时间格式化
     */
    public static final JsonSerializer<java.util.Date> DATE_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(dateFormat.format(value));
        }
    };

    /**
     * Long转String
     */
    public static final JsonSerializer<java.lang.Long> LONG_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(String.valueOf(value));
        }
    };

    /**
     * Year转String
     */
    public static final JsonSerializer<java.time.Year> YEAR_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.Year value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy")));
        }
    };

    /**
     * YearMonth转String
     */
    public static final JsonSerializer<java.time.YearMonth> YEAR_MONTH_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.YearMonth value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        }
    };
    /**
     * MonthDay转String
     */
    public static final JsonSerializer<java.time.MonthDay> MONTH_DAY_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.MonthDay value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern("MM-dd")));
        }
    };


    /**
     * LocalDate转String
     */
    public static final JsonSerializer<java.time.LocalDate> LOCAL_DATE_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
    };

    /**
     * LocalDateTime转String
     */
    public static final JsonSerializer<java.time.LocalDateTime> LOCAL_DATE_TIME_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    };
    /**
     * LocalTime转String
     */
    public static final JsonSerializer<java.time.LocalTime> LOCAL_TIME_SERIALIZER = new JsonSerializer<>() {
        @Override
        public void serialize(java.time.LocalTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }
    };


}