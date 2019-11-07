package io.pivotal.bookshop.config;

import io.pivotal.bookshop.domain.Customer;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.geode.config.annotation.EnableClusterAware;

@Configuration
@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.CACHING_PROXY)
public class GemFireConfiguration {

    @Bean("Customer")
    public ClientRegionFactoryBean<Integer, Customer> customerRegion(GemFireCache cache) {
        ClientRegionFactoryBean<Integer, Customer> customers = new ClientRegionFactoryBean<>();
        customers.setCache(cache);
        customers.setClose(true);
        customers.setShortcut(ClientRegionShortcut.PROXY);
        return customers;
    }


}
