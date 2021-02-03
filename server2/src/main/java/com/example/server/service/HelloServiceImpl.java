package com.example.server.service;

import com.example.server.aspect.ptTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class HelloServiceImpl implements HelloService {


    @Value("${server.port}")
    String port;

    @Override
    public String home(@RequestParam(value = "name", defaultValue = "hqh") String name) {
        return name+"-端口号:"+port;
    }
}
