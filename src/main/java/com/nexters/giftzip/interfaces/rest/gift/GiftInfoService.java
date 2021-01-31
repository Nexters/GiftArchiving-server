package com.nexters.giftzip.interfaces.rest.gift;

import com.nexters.giftzip.interfaces.rest.gift.dto.GiftCreateDto;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoDocument;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoRepository;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftInfoMapper;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftInfoService {
    private final GiftInfoRepository giftInfoRepository;
    private final GiftInfoMapper mapper;

    public void createGiftInfo(GiftCreateDto giftCreateRequest) {
        GiftInfoDocument giftInfoDocument = new GiftInfoDocument();
        giftInfoDocument.setCategory(giftCreateRequest.getCategory());
        giftInfoDocument.setContent(giftCreateRequest.getContent());
        giftInfoDocument.setBgColor(giftCreateRequest.getBgColor());
        giftInfoDocument.setEmotion(giftCreateRequest.getEmotion());
        giftInfoDocument.setIsReceiveGift(giftCreateRequest.getIsReceiveGift());
        giftInfoDocument.setFrameType(giftCreateRequest.getFrameType());
        giftInfoDocument.setSticker(giftCreateRequest.getSticker());
        giftInfoDocument.setImgUrl(giftCreateRequest.getImgUrl());
        giftInfoDocument.setCreatedBy(giftCreateRequest.getCreatedBy());
        giftInfoDocument.setReceiveDate(giftCreateRequest.getReceiveDate());
        giftInfoRepository.save(giftInfoDocument);
    }

    public GiftListResponse getGiftListResponse(String createdBy) {
        List<GiftInfoDocument> giftInfoDocuments = giftInfoRepository.findGiftInfoDocumentByCreatedBy(createdBy);
        List<GiftListDto> giftListDtos = giftInfoDocuments.stream().map(mapper::entityToResult).collect(Collectors.toList());
        return GiftListResponse.of(giftListDtos);
    }
}
