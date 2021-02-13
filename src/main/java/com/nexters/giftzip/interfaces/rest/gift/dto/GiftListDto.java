package com.nexters.giftzip.interfaces.rest.gift.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nexters.giftzip.interfaces.common.tag.Category;
import com.nexters.giftzip.interfaces.common.tag.Emotion;
import com.nexters.giftzip.interfaces.common.tag.Reason;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GiftListDto {
    private String id;
    private String imgUrl;
    private String name;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd\'T\'HH:mm:ss")
    private LocalDateTime receiveDate;
    private String bgColor;
    private Boolean isReceiveGift;
    private Category category;
    private Emotion emotion;
    private Reason reason;

    public GiftListDto() { }

    @Builder
    public GiftListDto(String id, String imgUrl, String name, String content, LocalDateTime receiveDate, Category category,
                       Emotion emotion, Reason reason, String bgColor, Boolean isReceiveGift) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.content = content;
        this.receiveDate = receiveDate;
        this.category = category;
        this.emotion = emotion;
        this.reason = reason;
        this.bgColor = bgColor;
        this.isReceiveGift = isReceiveGift;
    }
}
