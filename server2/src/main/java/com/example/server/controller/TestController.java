package com.example.server.controller;

import com.example.server.TestDto;
import com.example.server.aspect.ptTest;
import com.example.server.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/home2")
    public String getName2(TestDto testDto){
        return "调用server-"+helloService.home(testDto.getName());
    }

    public static void main(String[] args) {
        List<TestDto> list = new ArrayList<>();
        TestDto testDto = new TestDto();
        testDto.setCompId("1");
        testDto.setName("hand");
        list.add(testDto);
        testDto = new TestDto();
        testDto.setCompId("2");
//        testDto.setName("zhenyun");
        list.add(testDto);
//        testDto.setCompId("3");
//        testDto.setName("zhendeyun");
//        list.add(testDto);
//        Map<String,String> map = list.stream().collect(Collectors.toMap(TestDto::getCompId,TestDto::getName));
        try {
            System.out.println(list.stream().collect(Collectors.toMap(TestDto::getCompId, x -> Optional.ofNullable(x.getName()).orElse(""))));
        }catch (Exception e){e.printStackTrace();}
//        System.out.println(map);
    }

}
