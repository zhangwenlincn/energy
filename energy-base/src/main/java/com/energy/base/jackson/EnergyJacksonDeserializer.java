package com.energy.base.jackson;

import com.energy.base.code.BaseCode;
import com.energy.base.exception.EnergyException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
public class EnergyJacksonDeserializer {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期反序列化
     */
    public static final JsonDeserializer<java.util.Date> DATE_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            try {
                return dateFormat.parse(jsonParser.getText());
            } catch (ParseException e) {
                throw new EnergyException(BaseCode.EXCEPTION_FAIL);
            }
        }
    };
    /**
     * 年份反序列化
     */
    public static final JsonDeserializer<java.time.Year> YEAR_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.Year deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.Year.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy"));
        }
    };

    /**
     * 年月反序列化
     */
    public static final JsonDeserializer<java.time.YearMonth> YEAR_MONTH_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.YearMonth deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.YearMonth.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy-MM"));
        }
    };
    /**
     * 月日反序列化
     */
    public static final JsonDeserializer<java.time.MonthDay> MONTH_DAY_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.MonthDay deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.MonthDay.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("MM-dd"));
        }
    };


    /**
     * LocalDate反序列化
     */
    public static final JsonDeserializer<LocalDate> LOCAL_DATE_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    };
    /**
     * LocalDateTime反序列化
     */
    public static final JsonDeserializer<java.time.LocalDateTime> LOCAL_DATE_TIME_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.LocalDateTime.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    };
    /**
     * LocalTime反序列化
     */
    public static final JsonDeserializer<java.time.LocalTime> LOCAL_TIME_DESERIALIZER = new JsonDeserializer<>() {
        @Override
        public java.time.LocalTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            return java.time.LocalTime.parse(jsonParser.getText(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
    };
}
