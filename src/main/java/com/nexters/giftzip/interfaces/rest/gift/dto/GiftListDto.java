package com.nexters.giftzip.interfaces.rest.gift.dto;

import lombok.Builder;

@Builder
public class GiftListDto {
    private String imgUrl;
    private String name;
    private String content;
}
