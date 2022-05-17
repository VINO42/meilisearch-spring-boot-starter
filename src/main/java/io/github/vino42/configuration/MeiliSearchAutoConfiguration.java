package io.github.vino42.configuration;

import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import io.github.vino42.service.DefaultMeiliSearchService;
import io.github.vino42.service.MeiliSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * =====================================================================================
 *
 * @Created :   2022/5/17 21:33
 * @Compiler :  jdk 8
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription : 自动装配类
 * =====================================================================================
 */
@Configuration
@EnableConfigurationProperties(MeiliSearchProperties.class)
public class MeiliSearchAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeiliSearchAutoConfiguration.class);

    @Autowired
    private MeiliSearchProperties meiliSearchClientProperties;

    @Bean
    @ConditionalOnMissingBean
    public Client createClient() {
        LOGGER.debug("start create meilisearch client...");
        Config config =
                new Config(
                        meiliSearchClientProperties.getHostUrl(), meiliSearchClientProperties.getApiKey());
        Client client = new Client(config);
        LOGGER.debug("end create meilisearch client...");
        return client;
    }

    @Bean
    @ConditionalOnMissingBean
    public MeiliSearchService meiliSearchService() {
        return new DefaultMeiliSearchService();
    }


}
