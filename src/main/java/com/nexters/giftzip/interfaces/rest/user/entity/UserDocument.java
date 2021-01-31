package com.nexters.giftzip.interfaces.rest.user.entity;

import com.nexters.giftzip.interfaces.rest.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "user")
public class UserDocument extends BaseEntity {
    @MongoId
    private String id;
    private String name;
    private String kakaoToken;
    private String appleToken;
}