package com.nexters.giftzip.interfaces.rest.gift;

import com.nexters.giftzip.interfaces.rest.gift.dto.GiftCreateDto;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoDocument;
import com.nexters.giftzip.interfaces.rest.gift.entity.GiftInfoRepository;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftDetailResponseMapper;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftInfoMapper;
import com.nexters.giftzip.interfaces.rest.gift.request.SpecificationRequest;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftDetailResponse;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftListResponse;
import com.nexters.giftzip.support.exception.CommonErrorType;
import com.nexters.giftzip.support.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftInfoService {
    private final GiftInfoRepository giftInfoRepository;
    private final GiftInfoMapper giftInfoMapper;
    private final GiftDetailResponseMapper giftDetailResponseMapper;

    public String createGiftInfo(GiftCreateDto giftCreateRequest) {
        GiftInfoDocument giftInfoDocument = new GiftInfoDocument();
        giftInfoDocument.setCategory(giftCreateRequest.getCategory());
        giftInfoDocument.setContent(giftCreateRequest.getContent());
        giftInfoDocument.setEmotion(giftCreateRequest.getEmotion());
        giftInfoDocument.setIsReceiveGift(giftCreateRequest.getIsReceiveGift());
        giftInfoDocument.setBgImgUrl(giftCreateRequest.getBgImgUrl());
        giftInfoDocument.setNoBgImgUrl(giftCreateRequest.getNoBgimgUrl());
        giftInfoDocument.setName(giftCreateRequest.getName());
        giftInfoDocument.setCreatedBy(giftCreateRequest.getCreatedBy());
        giftInfoDocument.setReceiveDate(giftCreateRequest.getReceiveDate());
        return giftInfoRepository.save(giftInfoDocument).getId();
    }

    public GiftListResponse getGiftListResponse(SpecificationRequest request) {
        Page<GiftInfoDocument> giftInfoDocuments = giftInfoRepository.findAll(request.getPredicate(), request.getPageable());
        List<GiftListDto> giftListDtos = giftInfoDocuments.stream().map(giftInfoMapper::entityToResult).collect(Collectors.toList());
        return GiftListResponse.of(giftListDtos, giftInfoDocuments.getPageable(), giftInfoDocuments.getTotalElements());
    }

    public GiftDetailResponse getGiftDetail(String giftId) {
        GiftInfoDocument giftInfoDocument = giftInfoRepository.findById(new ObjectId(giftId)).orElseThrow(() -> new NotFoundException(CommonErrorType.DATA_NOT_FOUND));
        return giftDetailResponseMapper.entityToResult(giftInfoDocument);
    }
}
