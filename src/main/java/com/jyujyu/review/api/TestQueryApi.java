package com.jyujyu.review.api;

import com.jyujyu.review.model.TestEntity;
import com.jyujyu.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJPA(){
        return testService.findAllByNameByJPA("jyujyu");
    }
    /*여러가지 이름을 가지고 보여줄 수 있는 방식
    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJPA(
        @RequestParam("name") String name
        ){
        return testService.findAllByNameByJPA(name);
        }

     */

    @GetMapping("/test/query/querydsl")
    public List<TestEntity> queryQuerydsl(){
        return testService.findAllByNameByQuerydsl("jyujyu");
    }
}
