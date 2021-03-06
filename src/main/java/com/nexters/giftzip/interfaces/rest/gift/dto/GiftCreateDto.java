package com.nexters.giftzip.interfaces.rest.gift.dto;

import com.nexters.giftzip.interfaces.common.tag.Category;
import com.nexters.giftzip.interfaces.common.tag.Emotion;
import com.nexters.giftzip.interfaces.common.tag.FrameType;
import com.nexters.giftzip.interfaces.common.tag.Reason;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class GiftCreateDto {
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private String bgColor;
    private String createdBy;
    private Category category;
    private Emotion emotion;
    private Reason reason;
    private String noBgimgUrl;
    private String bgImgUrl;
    private FrameType frameType;

    public void setImgUrl(String noBgImgUrl, String bgImgUrl) {
        this.bgImgUrl = bgImgUrl;
        this.noBgimgUrl = noBgImgUrl;
    }
}
