package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRequest {

    //Request parameter 방식
    @GetMapping("test/param")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ){
        return "Hello, Request Param, I am " + name + ", " + age;
    }

    //Path Varaiable 방식
    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ){
        return "Hello, Path Variable, I am " + name + ", " + age;
    }
}