package com.energy.starter.configuration;

import com.energy.starter.exception.GlobalExceptionHandler;
import com.energy.starter.spring.SpringUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@Configuration
@Import({GlobalExceptionHandler.class, SpringUtil.class})
public class EnergyStarterConfiguration {
}
