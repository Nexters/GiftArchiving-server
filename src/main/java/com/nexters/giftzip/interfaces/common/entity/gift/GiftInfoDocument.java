package com.nexters.giftzip.interfaces.common.entity.gift;

import com.nexters.giftzip.interfaces.common.BaseEntity;
import com.nexters.giftzip.interfaces.common.tag.Category;
import com.nexters.giftzip.interfaces.common.tag.Emotion;
import com.nexters.giftzip.interfaces.common.tag.FrameType;
import com.nexters.giftzip.interfaces.common.tag.Reason;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@QueryEntity
@Document(collection = "gift_info")
public class GiftInfoDocument extends BaseEntity {
    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    private String createdBy;
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private String bgImgUrl;
    private String noBgImgUrl;
    private String bgColor;
    private Category category;
    private Emotion emotion;
    private FrameType frameType;
    private Reason reason;
}
