package com.sms.demo.com.sms.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzhibin
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        return "hello world";
    }

}
