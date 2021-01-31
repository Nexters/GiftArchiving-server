package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameType;
import com.nexters.giftzip.interfaces.rest.gift.entity.Sticker;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GiftCreateRequest {
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private String bgColor;
    private FrameType frameType;
    private String createdBy;
    private Category category;
    private Emotion emotion;
}