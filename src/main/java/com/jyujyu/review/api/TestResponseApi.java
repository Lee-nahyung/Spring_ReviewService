package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApi {

    @GetMapping("/test/response/string")
    public String stringResponse() {
        return "This is String";
    }

    @GetMapping("/test/response/json")
    public TestRequestBody jsonResponse(){
        return new TestRequestBody("jyujyu", 20);
    }

    public static class TestRequestBody{

        String name;
        Integer age;

        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}

