package com.forezp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzhipeng on 2017/6/13.
 */

@Service
public class RibbonService {
//2.在这里使用结合了ribbon的restTemplate
    @Autowired
    RestTemplate restTemplate;

    public String hi(String name) {
//        eureka-client服务名
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }
}
