package com.jyujyu.review.repository;

import com.jyujyu.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom{ //Long은 TestEntity의 @Id가 있는 엔터티의 타입

    public List<TestEntity> findAllByName(String name);
}
