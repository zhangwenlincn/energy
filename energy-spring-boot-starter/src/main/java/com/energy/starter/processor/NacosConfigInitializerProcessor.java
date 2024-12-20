package com.energy.starter.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

/**
 * @author zhangwenlin
 * @since 2024-12-20
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class NacosConfigInitializerProcessor implements EnvironmentPostProcessor {

    private final static String NACOS_PROPERTIES = "config/nacos.properties";
    private final static String SPRING_CLOUD_NACOS_DISCOVERY_SERVER_ADDR = "spring.cloud.nacos.discovery.server-addr";
    private final static String SPRING_CLOUD_NACOS_DISCOVERY_NAMESPACE = "spring.cloud.nacos.discovery.namespace";
    private final static String SPRING_CLOUD_NACOS_DISCOVERY_GROUP = "spring.cloud.nacos.discovery.group";
    private final static String SPRING_CLOUD_NACOS_DISCOVERY_USERNAME = "spring.cloud.nacos.discovery.username";
    private final static String SPRING_CLOUD_NACOS_DISCOVERY_PASSWORD = "spring.cloud.nacos.discovery.password";
    private final static String SPRING_CLOUD_NACOS_CONFIG_SERVER_ADDR = "spring.cloud.nacos.config.server-addr";
    private final static String SPRING_CLOUD_NACOS_CONFIG_NAMESPACE = "spring.cloud.nacos.config.namespace";
    private final static String SPRING_CLOUD_NACOS_CONFIG_GROUP = "spring.cloud.nacos.config.group";
    private final static String SPRING_CLOUD_NACOS_CONFIG_USERNAME = "spring.cloud.nacos.config.username";
    private final static String SPRING_CLOUD_NACOS_CONFIG_PASSWORD = "spring.cloud.nacos.config.password";
    private final static String SPRING_PROFILES_ACTIVE = "spring.profiles.active";
    private final static String POINT = ".";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        ClassPathResource classPathResource = new ClassPathResource(NACOS_PROPERTIES);
        String active = Optional.ofNullable(environment.getProperty(SPRING_PROFILES_ACTIVE)).orElse("local");
        Map<String, Object> activeProperties = new HashMap<>();
        activeProperties.put(SPRING_PROFILES_ACTIVE, active);
        environment.getPropertySources().addLast(new MapPropertySource(SPRING_PROFILES_ACTIVE, activeProperties));
        Map<String, Object> nacosProperties = getResource(active, classPathResource);
        nacosProperties.entrySet().removeIf(x -> Objects.isNull(x.getValue()));
        environment.getPropertySources().addLast(new MapPropertySource(NACOS_PROPERTIES, nacosProperties));
    }

    public Map<String, Object> getResource(String property, ClassPathResource classPathResource) {
        try {
            Properties prop = new Properties();
            HashMap<String, Object> map = new HashMap<>();
            InputStream inputStream = classPathResource.getInputStream();
            prop.load(inputStream);
            map.put(SPRING_CLOUD_NACOS_DISCOVERY_SERVER_ADDR, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_DISCOVERY_SERVER_ADDR));
            map.put(SPRING_CLOUD_NACOS_DISCOVERY_NAMESPACE, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_DISCOVERY_NAMESPACE));
            map.put(SPRING_CLOUD_NACOS_DISCOVERY_GROUP, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_DISCOVERY_GROUP));
            map.put(SPRING_CLOUD_NACOS_DISCOVERY_USERNAME, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_DISCOVERY_USERNAME));
            map.put(SPRING_CLOUD_NACOS_DISCOVERY_PASSWORD, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_DISCOVERY_PASSWORD));
            map.put(SPRING_CLOUD_NACOS_CONFIG_SERVER_ADDR, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_CONFIG_SERVER_ADDR));
            map.put(SPRING_CLOUD_NACOS_CONFIG_NAMESPACE, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_CONFIG_NAMESPACE));
            map.put(SPRING_CLOUD_NACOS_CONFIG_GROUP, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_CONFIG_GROUP));
            map.put(SPRING_CLOUD_NACOS_CONFIG_USERNAME, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_CONFIG_USERNAME));
            map.put(SPRING_CLOUD_NACOS_CONFIG_PASSWORD, prop.getProperty(property + POINT + SPRING_CLOUD_NACOS_CONFIG_PASSWORD));
            map.values().removeIf(Objects::isNull);
            inputStream.close();
            return map;
        } catch (IOException fe) {
            throw new RuntimeException("读取配置nacos.properties异常");
        }
    }
}
