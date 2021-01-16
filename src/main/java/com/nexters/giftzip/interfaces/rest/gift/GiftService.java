package com.nexters.giftzip.interfaces.rest.gift;

import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoDocument;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GiftService {
    private final GiftInfoRepository giftInfoRepository;

    public void createGiftInfo(GiftCreateRequest giftCreateRequest) {
        GiftInfoDocument giftInfoDocument = new GiftInfoDocument();
        giftInfoDocument.setCategory(giftCreateRequest.getCategory());
        giftInfoDocument.setContent(giftCreateRequest.getContent());
        giftInfoDocument.setBgColor(giftCreateRequest.getBgColor());
        giftInfoDocument.setEmotion(giftCreateRequest.getEmotion());
        giftInfoDocument.setIsReceiveGift(giftCreateRequest.getIsReceiveGift());
        giftInfoDocument.setFrameSort(giftCreateRequest.getFrameSort());
        giftInfoDocument.setSticker(giftCreateRequest.getSticker());
        giftInfoDocument.setStickerSort(giftCreateRequest.getStickerSort());
        giftInfoDocument.setImgUrl(giftCreateRequest.getImgUrl());
        giftInfoDocument.setReceiveDate(giftCreateRequest.getReceiveDate());
        giftInfoRepository.save(giftInfoDocument);
    }
}
