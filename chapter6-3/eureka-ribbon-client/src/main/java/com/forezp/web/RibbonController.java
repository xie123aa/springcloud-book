package com.forezp.web;

import com.forezp.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Created by fangzhipeng on 2017/6/13.
 */
@RestController
public class RibbonController {
    //3.使用之前的service
    @Autowired
    RibbonService ribbonService;
    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "forezp") String name){
        return ribbonService.hi(name);
    }
    //3结束——————————————————————————

    //4.另一种灵活的方式，loadBalancer可以轮流获取负载信息
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/testRibbon")
    public String  testRibbon() {
        ServiceInstance instance = loadBalancer.choose("eureka-client");
      //  URI uri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        return instance.getHost()+":"+instance.getPort();
    }
}
