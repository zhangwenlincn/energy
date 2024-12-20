package com.energy.starter.transfer;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.NacosNamingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static com.alibaba.nacos.api.PropertyKeyConst.NAMESPACE;

/**
 * @author zhangwenlin
 * @since 2024-12-20
 */
public class NacosTransferServiceDiscovery extends NacosServiceDiscovery {

    private static final Logger log = LoggerFactory.getLogger(NacosTransferServiceDiscovery.class);

    private final NacosDiscoveryProperties discoveryProperties;
    private final NacosDiscoveryTransferProperties nacosDiscoveryTransferProperties;


    public NacosTransferServiceDiscovery(NacosDiscoveryProperties discoveryProperties
            , NacosServiceManager nacosServiceManager
            , NacosDiscoveryTransferProperties nacosDiscoveryTransferProperties) {
        super(discoveryProperties, nacosServiceManager);
        this.discoveryProperties = discoveryProperties;
        this.nacosDiscoveryTransferProperties = nacosDiscoveryTransferProperties;
    }

    @Override
    public List<ServiceInstance> getInstances(String serviceId) throws NacosException {

        List<NacosDiscoveryTransferProperties.Transfer> transfers = nacosDiscoveryTransferProperties.getTransfers();
        boolean match = transfers.stream().anyMatch(x -> x.getServiceId().equals(serviceId));
        if (match) {
            NacosDiscoveryTransferProperties.Transfer transfer = transfers.stream().filter(x -> Objects.equals(x.getServiceId(), serviceId)).toList().getFirst();
            log.debug("transfer to nacos discovery serviceId:{}, namespace:{}, group:{} ", serviceId, transfer.getNamespace(), transfer.getGroup());
            Properties nacosProperties = discoveryProperties.getNacosProperties();
            nacosProperties.put(NAMESPACE, transfer.namespace);
            NamingService namingService = new NacosNamingService(nacosProperties);
            List<Instance> instances = namingService.selectInstances(serviceId, transfer.group,
                    true);
            return hostToServiceInstanceList(instances, serviceId);
        }
        return super.getInstances(serviceId);
    }
}
