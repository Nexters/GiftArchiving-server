package com.nexters.giftzip.interfaces.rest.gift.mapper;

import com.nexters.giftzip.interfaces.rest.common.EntityMapper;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftCreateDto;
import com.nexters.giftzip.interfaces.rest.gift.request.GiftCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GiftCreateDtoMapper implements EntityMapper<GiftCreateRequest, GiftCreateDto> {

    @Override
    public GiftCreateDto entityToResult(GiftCreateRequest giftCreateRequest) {
        return GiftCreateDto.builder()
                .content(giftCreateRequest.getContent())
                .bgColor(giftCreateRequest.getBgColor())
                .createdBy(giftCreateRequest.getCreatedBy())
                .isReceiveGift(giftCreateRequest.getIsReceiveGift())
                .receiveDate(giftCreateRequest.getReceiveDate())
                .category(giftCreateRequest.getCategory())
                .emotion(giftCreateRequest.getEmotion())
                .frameType(giftCreateRequest.getFrameType())
                .name(giftCreateRequest.getName())
                .build();
    }
}
