package com.nexters.giftzip.interfaces.rest.gift.response;

import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftListResponse {
    private List<GiftListDto> gifts;

    public static GiftListResponse of(List<GiftListDto> gifts) {
        return new GiftListResponse(gifts);
    }
}
