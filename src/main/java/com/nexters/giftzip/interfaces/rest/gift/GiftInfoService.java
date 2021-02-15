package com.nexters.giftzip.interfaces.rest.gift;

import com.google.common.collect.Lists;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftCreateDto;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import com.nexters.giftzip.interfaces.common.entity.gift.GiftInfoDocument;
import com.nexters.giftzip.interfaces.common.entity.gift.GiftInfoRepository;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftDetailResponseMapper;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftInfoMapper;
import com.nexters.giftzip.interfaces.rest.gift.request.GiftEditRequest;
import com.nexters.giftzip.interfaces.rest.gift.request.SpecificationRequest;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftCreateResponse;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftDetailResponse;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftListResponse;
import com.nexters.giftzip.support.exception.CommonErrorType;
import com.nexters.giftzip.support.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftInfoService {
    private final GiftInfoRepository giftInfoRepository;
    private final GiftInfoMapper giftInfoMapper;
    private final GiftDetailResponseMapper giftDetailResponseMapper;
    private final ImgService imgService;


    public GiftCreateResponse createGiftInfo(GiftCreateDto giftCreateRequest) {
        GiftInfoDocument giftInfoDocument = new GiftInfoDocument();
        giftInfoDocument.setCategory(giftCreateRequest.getCategory());
        giftInfoDocument.setContent(giftCreateRequest.getContent());
        giftInfoDocument.setEmotion(giftCreateRequest.getEmotion());
        giftInfoDocument.setIsReceiveGift(giftCreateRequest.getIsReceiveGift());
        giftInfoDocument.setBgColor(giftCreateRequest.getBgColor());
        giftInfoDocument.setBgImgUrl(giftCreateRequest.getBgImgUrl());
        giftInfoDocument.setNoBgImgUrl(giftCreateRequest.getNoBgimgUrl());
        giftInfoDocument.setName(giftCreateRequest.getName());
        giftInfoDocument.setCreatedBy(giftCreateRequest.getCreatedBy());
        giftInfoDocument.setReceiveDate(giftCreateRequest.getReceiveDate());
        giftInfoDocument.setReason(giftCreateRequest.getReason());
        giftInfoDocument.setFrameType(giftCreateRequest.getFrameType());
        String id = giftInfoRepository.save(giftInfoDocument).getId();

        return GiftCreateResponse.of(giftCreateRequest.getNoBgimgUrl(), giftCreateRequest.getBgImgUrl(), id);
    }

    public GiftListResponse getGiftListResponse(SpecificationRequest request) {
        Page<GiftInfoDocument> giftInfoDocuments = giftInfoRepository.findAll(request.getPredicate(), request.getPageable());
        List<GiftListDto> giftListDtos = giftInfoDocuments.stream().map(giftInfoMapper::entityToResult).collect(Collectors.toList());
        return GiftListResponse.of(giftListDtos, giftInfoDocuments.getPageable(), giftInfoDocuments.getTotalElements());
    }

    public GiftDetailResponse getGiftDetail(String giftId) {
        GiftInfoDocument giftInfoDocument = giftInfoRepository.findById(giftId).orElseThrow(() -> new NotFoundException(CommonErrorType.DATA_NOT_FOUND));
        return giftDetailResponseMapper.entityToResult(giftInfoDocument);
    }

    public void removeGiftInfo(String giftId) {
        GiftInfoDocument giftInfoDocument = giftInfoRepository.findById(giftId).orElseThrow(() -> new NotFoundException(CommonErrorType.DATA_NOT_FOUND));
        imgService.removeImgFromS3(Lists.newArrayList(giftInfoDocument.getBgImgUrl(), giftInfoDocument.getNoBgImgUrl()));
        giftInfoRepository.deleteById(giftId);
    }

    public void updateGiftInfo(String giftId, GiftEditRequest request) {
        GiftInfoDocument giftInfoDocument = giftInfoRepository.findById(giftId).orElseThrow(() -> new NotFoundException(CommonErrorType.DATA_NOT_FOUND));
        giftInfoDocument.setCategory(request.getCategory());
        giftInfoDocument.setContent(request.getContent());
        giftInfoDocument.setBgColor(request.getBgColor());
        giftInfoDocument.setEmotion(request.getEmotion());
        giftInfoDocument.setReason(request.getReason());
        giftInfoDocument.setName(request.getName());
        giftInfoDocument.setReceiveDate(request.getReceiveDate());
        giftInfoRepository.save(giftInfoDocument);
    }
}
