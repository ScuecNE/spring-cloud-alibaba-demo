package com.sugus.alibabanacosdiscoveryclientcommon.controller;

import com.sugus.alibabanacosdiscoveryclientcommon.service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ClientController {

    /*@Autowired
    private LoadBalancerClient loadBalancerClient;*/

    @Autowired
    private ServerService serverService;

    @GetMapping("/test")
    @ResponseBody
    public String test(@RequestParam String name) {
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);*/
        String result = serverService.hello(name);
        return "return : " + result;
    }

}
