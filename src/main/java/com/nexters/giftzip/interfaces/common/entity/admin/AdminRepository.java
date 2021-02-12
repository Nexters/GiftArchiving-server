package com.nexters.giftzip.interfaces.common.entity.admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AdminRepository extends MongoRepository<AdminDocument, String>, QuerydslPredicateExecutor<AdminDocument> {
    List<AdminDocument> findAllByOrderByCreatedAtDesc();
}
