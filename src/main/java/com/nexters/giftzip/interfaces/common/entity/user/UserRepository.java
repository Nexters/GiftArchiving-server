package com.nexters.giftzip.interfaces.common.entity.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findByToken(String token);
    void deleteByToken(String token);
}
