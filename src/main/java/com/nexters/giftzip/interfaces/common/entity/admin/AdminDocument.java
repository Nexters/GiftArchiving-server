package com.nexters.giftzip.interfaces.common.entity.admin;

import com.nexters.giftzip.interfaces.common.BaseEntity;
import com.nexters.giftzip.interfaces.common.entity.user.LoginType;
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
public class AdminDocument extends BaseEntity {
    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    private String title;
    private String content;
}
