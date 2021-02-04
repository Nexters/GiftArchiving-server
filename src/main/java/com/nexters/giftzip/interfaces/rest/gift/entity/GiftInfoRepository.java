package com.nexters.giftzip.interfaces.rest.gift.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface GiftInfoRepository extends MongoRepository<GiftInfoDocument, ObjectId>, QuerydslPredicateExecutor<GiftInfoDocument> {
    Optional<GiftInfoDocument> findById(ObjectId objectId);
}
