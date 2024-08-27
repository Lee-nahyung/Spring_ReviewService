package com.jyujyu.review.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl {
    private final JPAQueryFactory queryFactory;


}
