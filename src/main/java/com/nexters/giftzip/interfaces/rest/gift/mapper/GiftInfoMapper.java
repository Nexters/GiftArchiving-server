package com.nexters.giftzip.interfaces.rest.gift.mapper;

import com.nexters.giftzip.interfaces.common.EntityMapper;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import com.nexters.giftzip.interfaces.common.entity.gift.GiftInfoDocument;
import org.springframework.stereotype.Component;

@Component
public class GiftInfoMapper implements EntityMapper<GiftInfoDocument, GiftListDto> {
    @Override
    public GiftListDto entityToResult(GiftInfoDocument giftInfoDocument) {
        return GiftListDto.builder()
                .id(giftInfoDocument.getId())
                .name(giftInfoDocument.getName())
                .content(giftInfoDocument.getContent())
                .imgUrl(giftInfoDocument.getBgImgUrl())
                .isReceiveGift(giftInfoDocument.getIsReceiveGift())
                .receiveDate(giftInfoDocument.getReceiveDate())
                .category(giftInfoDocument.getCategory())
                .emotion(giftInfoDocument.getEmotion())
                .reason(giftInfoDocument.getReason())
                .bgColor(giftInfoDocument.getBgColor())
                .build();
    }
}
