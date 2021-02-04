package com.nexters.giftzip.interfaces.rest.gift.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GiftListDto {
    private String id;
    private String imgUrl;
    private String name;
    private String content;

    public GiftListDto() { }

    @Builder
    public GiftListDto(String id, String imgUrl, String name, String content) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.content = content;
    }
}
