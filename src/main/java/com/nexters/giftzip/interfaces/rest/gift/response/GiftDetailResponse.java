package com.nexters.giftzip.interfaces.rest.gift.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nexters.giftzip.interfaces.common.tag.Category;
import com.nexters.giftzip.interfaces.common.tag.Emotion;
import com.nexters.giftzip.interfaces.common.tag.FrameType;
import com.nexters.giftzip.interfaces.common.tag.Reason;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GiftDetailResponse {
    private String id;
    private String createdBy;
    private String content;
    private Boolean isReceiveGift;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd\'T\'HH:mm:ss")
    private LocalDateTime receiveDate;
    @JsonFormat(pattern = "yyyy-MM-dd\'T\'HH:mm:ss")
    private LocalDateTime createdAt;
    private String bgImgUrl;
    private String noBgImgUrl;
    private String bgColor;
    private FrameType frameType;
    private Category category;
    private Emotion emotion;
    private Reason reason;
}
