package com.nexters.giftzip.interfaces.rest.gift.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftCreateResponse {
    private String noBgImg;
    private String bgImg;
    private String id;

    public static GiftCreateResponse of(String noBgImg, String bgImg, String id) {
        return new GiftCreateResponse(noBgImg, bgImg, id);
    }
}
