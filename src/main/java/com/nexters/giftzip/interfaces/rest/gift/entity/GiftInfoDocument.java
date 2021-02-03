package com.nexters.giftzip.interfaces.rest.gift.entity;

import com.nexters.giftzip.interfaces.rest.common.BaseEntity;
import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameType;
import com.nexters.giftzip.interfaces.rest.common.tag.StickerSort;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@QueryEntity
@Document(collection = "gift_info")
public class GiftInfoDocument extends BaseEntity {
    @MongoId
    private String id;
    private String createdBy;
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private String imgUrl;
    private String bgColor;
    private FrameType frameType;
    private List<Sticker> sticker;
    private Category category;
    private Emotion emotion;
    private StickerSort stickerSort;
}
