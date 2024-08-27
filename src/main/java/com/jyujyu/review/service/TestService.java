package com.jyujyu.review.service;

import com.jyujyu.review.model.TestEntity;
import com.jyujyu.review.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor//생성자 역할을 lombok을 사용해 대신
@Service
public class TestService {
    private final TestRepository testRepository;

    public void create(String name, Integer age){
        TestEntity testEntity = new TestEntity(name, age);
        testRepository.save(testEntity);
    }

    public void update(Long id, String name, Integer age){
        TestEntity testEntity = testRepository.findById(id).orElseThrow(); //orElseThrow()는 아이디가 없을 경우 예외처리
        testEntity.changeNameAndAge(name, age);
        testRepository.save(testEntity);
    }
    public void delete(Long id){
        TestEntity testEntity = testRepository.findById(id).get();
        testRepository.delete(testEntity);
    }

    public List<TestEntity> findAllByNameByJPA(String name){
        return testRepository.findAllByName(name);
    }
}
