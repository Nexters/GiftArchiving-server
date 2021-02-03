package com.nexters.giftzip.interfaces.rest.gift.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GiftListDto {
    private String imgUrl;
    private String name;
    private String content;

    public GiftListDto() { }

    @Builder
    public GiftListDto(String imgUrl, String name, String content) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.content = content;
    }
}
