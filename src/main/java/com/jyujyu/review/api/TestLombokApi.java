package com.jyujyu.review.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLombokApi {

    @GetMapping("/test/lombok")
    public TestLombokResponseBody testLombok(){
        return new TestLombokResponseBody("jyujyu", 20);
    }

    @Getter//게터
    @AllArgsConstructor //생성자
    public static class TestLombokResponseBody {
        String name;
        Integer age;
    }
}
