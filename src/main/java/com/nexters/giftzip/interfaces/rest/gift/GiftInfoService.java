package com.nexters.giftzip.interfaces.rest.gift;

import com.nexters.giftzip.interfaces.rest.gift.dto.GiftCreateDto;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoDocument;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoRepository;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftInfoMapper;
import com.nexters.giftzip.interfaces.rest.gift.request.GiftGetByCreationRequest;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftInfoService {
    private final GiftInfoRepository giftInfoRepository;
    private final GiftInfoMapper mapper;

    public String createGiftInfo(GiftCreateDto giftCreateRequest) {
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
        return giftInfoRepository.save(giftInfoDocument).getId();
    }

    public GiftListResponse getGiftListResponse(GiftGetByCreationRequest request) {
        Page<GiftInfoDocument> giftInfoDocuments = giftInfoRepository.findAll(request.getPredicate(), request.getPageable());
        List<GiftListDto> giftListDtos = giftInfoDocuments.stream().map(mapper::entityToResult).collect(Collectors.toList());
        return GiftListResponse.of(giftListDtos, giftInfoDocuments.getPageable(), giftInfoDocuments.getTotalElements());
    }
}
