package com.example.feign.service;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystric implements FeignService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry! 网络异常，服务暂时无法访问。 请求的name为:"+name;
    }

}
