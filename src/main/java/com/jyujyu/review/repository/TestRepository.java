package com.jyujyu.review.repository;

import com.jyujyu.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> { //Long은 TestEntity의 @Id가 있는 엔터티의 타입

}
