package com.nexters.giftzip.interfaces.rest.gift;

import com.amazonaws.util.json.Jackson;
import com.nexters.giftzip.interfaces.common.Order;
import com.nexters.giftzip.interfaces.rest.gift.dto.GiftCreateDto;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftCreateDtoMapper;
import com.nexters.giftzip.interfaces.rest.gift.request.*;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftDetailResponse;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftListResponse;
import com.nexters.giftzip.interfaces.rest.gift.validator.GiftCreateRequestValidator;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/api/gift")
@RequiredArgsConstructor
public class GiftController {
    private final GiftInfoService giftService;
    private final GiftCreateDtoMapper giftCreateDtoMapper;
    private final ImgService imgService;
    private final GiftCreateRequestValidator validator;


    @ApiOperation(value = "기록 저장", produces = "multipart/form-data", notes = "선물을 기록합니다.")
    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = {MediaType.MULTIPART_FORM_DATA_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@ModelAttribute("request") GiftCreateRequest giftCreateRequest, @RequestPart MultipartFile bgImg,
                                   @RequestPart MultipartFile noBgImg) {
        validator.validate(giftCreateRequest);
        GiftCreateDto giftCreateDto = giftCreateDtoMapper.entityToResult(giftCreateRequest);
        giftCreateDto.setImgUrl(getFileUrl(noBgImg, giftCreateDto.getCreatedBy()), getFileUrl(bgImg, giftCreateDto.getCreatedBy()));
        return Jackson.toJsonPrettyString(giftService.createGiftInfo(giftCreateDto));
    }

    @ApiOperation(value = "선물 기록 불러오기", notes = "특정 선물 기록을 불러옵니다.")
    @RequestMapping(path = "/{giftId}", method = RequestMethod.GET)
    public GiftDetailResponse getGiftInfo(@PathVariable String giftId) {
        return giftService.getGiftDetail(giftId);
    }

    @ApiOperation(value = "선물 기록 수정하기")
    @RequestMapping(value = "/{giftId}", method = RequestMethod.PUT)
    public void editGiftInfo(@PathVariable String giftId, @RequestBody GiftEditRequest request) {
        giftService.updateGiftInfo(giftId, request);
    }

    @ApiOperation(value = "선물 기록 삭제", notes = "특정 선물 기록을 제거합니다.")
    @RequestMapping(path = "/{giftId}", method = RequestMethod.DELETE)
    public void removeGiftInfo(@PathVariable String giftId) {
        giftService.removeGiftInfo(giftId);
    }

    @ApiOperation(value = "기록 목록 불러오기", notes = "선물 기록 목록을 불러온다.")
    @GetMapping("/user/{createdBy}")
    @ResponseBody
    public GiftListResponse getGiftInfo(@PathVariable String createdBy, @RequestParam Integer page, @RequestParam Integer size, @RequestParam Boolean isReceiveGift,
                                        @RequestParam(required = false) Order order) {
        return giftService.getGiftListResponse(GiftGetByCreationRequest.of(createdBy, page, size, isReceiveGift, order));
    }

    @ApiOperation(value = "태그 검색", notes = "태그 검색")
    @GetMapping("/{createdBy}/tag")
    @ResponseBody
    public GiftListResponse getGiftInfoByTag(@PathVariable String createdBy, @ModelAttribute GiftTagSearchRequest request) {
        GiftTagSearchSpecification giftTagSearchSpecification = GiftTagSearchSpecification.builder()
                .category(request.getCategory())
                .name(request.getName())
                .content(request.getContent())
                .emotion(request.getEmotion())
                .reason(request.getReason())
                .createdBy(createdBy)
                .page(request.getPage())
                .size(request.getSize())
                .order(request.getOrder())
                .build();
        return giftService.getGiftListResponse(giftTagSearchSpecification);
    }

    @ApiOperation(value = "이미지 업로드 테스트", produces = "multipart/form-data", notes = "업로드 테스트")
    @PostMapping("/testImg")
    public String testImg(@RequestParam MultipartFile img) {
        return getFileUrl(img, "test");
    }

    private String getFileUrl(MultipartFile file, String userToken) {
        return imgService.uploadImgToS3(file, userToken);
    }
}
