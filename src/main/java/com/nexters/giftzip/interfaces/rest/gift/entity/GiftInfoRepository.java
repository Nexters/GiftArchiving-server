package com.nexters.giftzip.interfaces.rest.gift.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GiftInfoRepository extends MongoRepository<GiftInfoDocument, ObjectId> {
    List<GiftInfoDocument> findGiftInfoDocumentByCreatedBy(String createdBy);
}
