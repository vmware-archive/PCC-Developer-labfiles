package io.pivotal.bookshop.config;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@Configuration
@EnableEntityDefinedRegions(basePackages = "io.pivotal.bookshop.domain", clientRegionShortcut = ClientRegionShortcut.CACHING_PROXY)
@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.CACHING_PROXY)
public class GemFireConfiguration {

}
