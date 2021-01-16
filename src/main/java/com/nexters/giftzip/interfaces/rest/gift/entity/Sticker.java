package com.nexters.giftzip.interfaces.rest.gift.entity;

import com.nexters.giftzip.interfaces.rest.common.tag.StickerSort;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Sticker {
    private Double x;
    private Double y;
    private Double r;
    private StickerSort stickerSort;
}
