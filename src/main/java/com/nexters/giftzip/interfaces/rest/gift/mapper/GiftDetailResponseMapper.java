package com.nexters.giftzip.interfaces.rest.gift.mapper;

import com.nexters.giftzip.interfaces.common.EntityMapper;
import com.nexters.giftzip.interfaces.common.entity.gift.GiftInfoDocument;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class GiftDetailResponseMapper implements EntityMapper<GiftInfoDocument, GiftDetailResponse> {
    @Override
    public GiftDetailResponse entityToResult(GiftInfoDocument giftInfoDocument) {
        return GiftDetailResponse.builder()
                .content(giftInfoDocument.getContent())
                .isReceiveGift(giftInfoDocument.getIsReceiveGift())
                .receiveDate(giftInfoDocument.getReceiveDate())
                .category(giftInfoDocument.getCategory())
                .bgImgUrl(giftInfoDocument.getBgImgUrl())
                .noBgImgUrl(giftInfoDocument.getNoBgImgUrl())
                .emotion(giftInfoDocument.getEmotion())
                .name(giftInfoDocument.getName())
                .createdBy(giftInfoDocument.getCreatedBy())
                .bgColor(giftInfoDocument.getBgColor())
                .createdAt(giftInfoDocument.getCreatedAt())
                .id(giftInfoDocument.getId())
                .reason(giftInfoDocument.getReason())
                .frameType(giftInfoDocument.getFrameType())
                .createdAt(giftInfoDocument.getCreatedAt())
                .build();
    }
}
