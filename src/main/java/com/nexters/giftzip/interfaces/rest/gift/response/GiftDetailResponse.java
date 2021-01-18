package com.nexters.giftzip.interfaces.rest.gift.response;

import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameSort;
import com.nexters.giftzip.interfaces.rest.common.tag.StickerSort;
import com.nexters.giftzip.interfaces.rest.gift.entity.Sticker;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class GiftDetailResponse {
    private String id;
    private String createdBy;
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private LocalDateTime createdAt;
    private String imgUrl;
    private String bgColor;
    private FrameSort frameSort;
    private List<Sticker> sticker;
    private Category category;
    private Emotion emotion;
    private StickerSort stickerSort;
}
