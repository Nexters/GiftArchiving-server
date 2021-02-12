package com.nexters.giftzip.interfaces.common.entity.user;

import com.nexters.giftzip.interfaces.common.BaseEntity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@QueryEntity
@Document(collection = "user")
public class UserDocument extends BaseEntity {
    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String token;
    private LoginType loginType;
}
