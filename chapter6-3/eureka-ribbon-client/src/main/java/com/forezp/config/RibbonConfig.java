package com.forezp.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzhipeng on 2017/6/13.
 * 1.在ioc容器中注入一个RestTemplate，并在这个bean上加上LoadBalanced注解，此时RestTemplate就结合ribbon
 */
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
