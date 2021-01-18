package com.nexters.giftzip.interfaces.rest.gift.mapper;

import com.nexters.giftzip.interfaces.rest.common.EntityMapper;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoDocument;
import org.springframework.stereotype.Component;

@Component
public class GiftInfoMapper implements EntityMapper<GiftInfoDocument, GiftListDto> {
    @Override
    public GiftListDto entityToResult(GiftInfoDocument giftInfoDocument) {
        return GiftListDto.builder()
                .name(giftInfoDocument.getName())
                .content(giftInfoDocument.getContent())
                .imgUrl(giftInfoDocument.getImgUrl())
                .build();
    }
}
