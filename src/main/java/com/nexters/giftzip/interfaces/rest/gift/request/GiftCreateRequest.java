package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameSort;
import com.nexters.giftzip.interfaces.rest.common.tag.StickerSort;
import com.nexters.giftzip.interfaces.rest.gift.entity.Sticker;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GiftCreateRequest {
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private String imgUrl;
    private String bgColor;
    private FrameSort frameSort;
    private List<Sticker> sticker;
    private String createdBy;
    private Category category;
    private Emotion emotion;
    private StickerSort stickerSort;
}
