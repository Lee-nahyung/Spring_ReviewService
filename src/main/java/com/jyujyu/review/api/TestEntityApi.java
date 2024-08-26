package com.jyujyu.review.api;

import com.jyujyu.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TestEntityApi {
    private final TestService testService;

    /*
    @GetMapping("/test/entity/create")
    public void createTestEntity(){
        testService.create("jyujyu", 20);
    }
     */

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ){
        testService.create(request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable Long id
    ){
        testService.delete(id);
    }

    @AllArgsConstructor
    @Getter
    public static class CreateTestEntityRequest{
        private final String name;
        private final Integer age;
    }
}
