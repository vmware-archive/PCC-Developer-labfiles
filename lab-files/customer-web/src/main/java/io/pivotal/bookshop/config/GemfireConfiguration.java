package io.pivotal.bookshop.config;

import io.pivotal.bookshop.domain.Customer;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication.Locator;
import org.springframework.data.gemfire.config.annotation.EnableSecurity;

@ClientCacheApplication(name="GemFireClient", locators = {
        @Locator(host = "localhost", port = 41111)
})
@EnableSecurity
public class GemfireConfiguration {

    @Bean("Customer")
    public ClientRegionFactoryBean<Integer, Customer> customerRegion(GemFireCache cache) {
        ClientRegionFactoryBean<Integer, Customer> customers = new ClientRegionFactoryBean<>();
        customers.setCache(cache);
        customers.setClose(true);
        customers.setShortcut(ClientRegionShortcut.PROXY);
        return customers;
    }

    @Bean
    @DependsOn("Customer")
    public GemfireTemplate gfTemplate(GemFireCache cache) {
        return new GemfireTemplate(cache.getRegion("Customer"));
    }
}