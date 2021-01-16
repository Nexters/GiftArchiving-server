package com.nexters.giftzip.interfaces.rest.gift.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GiftInfoRepository extends MongoRepository<GiftInfoDocument, ObjectId> {

}
