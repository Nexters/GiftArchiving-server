package com.nexters.giftzip.interfaces.rest.gift.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface GiftInfoRepository extends MongoRepository<GiftInfoDocument, String>, QuerydslPredicateExecutor<GiftInfoDocument> {

    Optional<GiftInfoDocument> findById(String objectId);
}
