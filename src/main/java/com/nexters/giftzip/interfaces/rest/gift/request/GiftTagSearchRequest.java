package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameType;
import com.nexters.giftzip.interfaces.rest.common.tag.StickerSort;

public class GiftTagSearchRequest {
    private Category category;
    private Emotion emotion;
    private StickerSort stickerSort;
    private int page;
    private int size;

}
