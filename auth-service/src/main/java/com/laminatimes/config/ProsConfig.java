package com.laminatimes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("url")
public class ProsConfig {
    private String url;

    public void setUrl(String url) {
        System.out.println("ProsConfig: -------------setUrl--------------" +url);

        this.url = url;
    }

    public String getUrl() {
        System.out.println("ProsConfig: -------------setUrl--------------" +this.url);
        return url;
    }
}
