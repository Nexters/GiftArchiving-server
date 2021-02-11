package com.nexters.giftzip.interfaces.rest.gift.mapper;

import com.nexters.giftzip.interfaces.rest.common.EntityMapper;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoDocument;
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
                .id(giftInfoDocument.getId())
                .reason(giftInfoDocument.getReason())
                .build();
    }
}