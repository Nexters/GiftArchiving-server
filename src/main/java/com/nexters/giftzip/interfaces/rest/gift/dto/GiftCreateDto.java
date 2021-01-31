package com.nexters.giftzip.interfaces.rest.gift.dto;

import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameType;
import com.nexters.giftzip.interfaces.rest.gift.entity.Sticker;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class GiftCreateDto {
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private String bgColor;
    private FrameType frameType;
    private List<Sticker> sticker;
    private String createdBy;
    private Category category;
    private Emotion emotion;
    private String imgUrl;

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
