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

import java.io.Serializable;

@Getter
@Setter
 @NoArgsConstructor
@QueryEntity
@Document(collection = "admin")
public class AdminDocument extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7024372273203716380L;

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    private String title;
    private String content;
}
