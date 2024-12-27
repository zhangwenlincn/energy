package com.energy.starter.configuration;

import com.alibaba.cloud.nacos.ConditionalOnNacosDiscoveryEnabled;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.discovery.NacosDiscoveryAutoConfiguration;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.energy.starter.transfer.NacosDiscoveryTransferProperties;
import com.energy.starter.transfer.NacosTransferServiceDiscovery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.ConditionalOnDiscoveryEnabled;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangwenlin
 * @since 2024-12-20
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnDiscoveryEnabled
@ConditionalOnNacosDiscoveryEnabled
@AutoConfigureBefore({NacosDiscoveryAutoConfiguration.class})
@EnableConfigurationProperties(NacosDiscoveryTransferProperties.class)
@ConditionalOnClass(NacosServiceDiscovery.class)
@ConditionalOnProperty(value = "energy.cloud.transfer.enabled", havingValue = "true")
public class NacosTransferConfiguration {

    private static final Logger log = LoggerFactory.getLogger(NacosTransferConfiguration.class);
    private final NacosDiscoveryTransferProperties nacosDiscoveryTransferProperties;

    public NacosTransferConfiguration(NacosDiscoveryTransferProperties nacosDiscoveryTransferProperties) {
        log.info("NacosTransferConfiguration init");
        this.nacosDiscoveryTransferProperties = nacosDiscoveryTransferProperties;
    }

    @Bean
    public NacosServiceDiscovery nacosServiceDiscovery(NacosDiscoveryProperties nacosDiscoveryProperties, NacosServiceManager nacosServiceManager) {
        log.info("nacosDiscoveryTransferProperties:{}", nacosDiscoveryTransferProperties.getTransfers());
        return new NacosTransferServiceDiscovery(nacosDiscoveryProperties, nacosServiceManager, nacosDiscoveryTransferProperties);
    }
}
