package com.sugus.alibabanacosdiscoveryserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
public class ServerController {

    @Value("${wong.name:}")
    private String wongName;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        log.info("invoked name = " + name);
        return "hello " + name + ",wong.name:" + wongName;
    }

}
