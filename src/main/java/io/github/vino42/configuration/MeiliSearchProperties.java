package io.github.vino42.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * =====================================================================================
 *
 * @Created :   2022/5/17 21:34
 * @Compiler :  jdk 8
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
@ConfigurationProperties(prefix = "meilisearch")
public class MeiliSearchProperties {

    private String hostUrl;

    private String apiKey;

    public String getHostUrl() {
        return hostUrl;
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "MeiliSearchProperties{" +
                "hostUrl='" + hostUrl + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
