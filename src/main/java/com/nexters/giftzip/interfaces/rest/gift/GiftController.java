package com.nexters.giftzip.interfaces.rest.gift;

import com.nexters.giftzip.interfaces.rest.gift.dto.GiftCreateDto;
import com.nexters.giftzip.interfaces.rest.gift.mapper.GiftCreateDtoMapper;
import com.nexters.giftzip.interfaces.rest.gift.request.GiftCreateRequest;
import com.nexters.giftzip.interfaces.rest.gift.request.GiftGetByCreationRequest;
import com.nexters.giftzip.interfaces.rest.gift.request.GiftTagSearchRequest;
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
    private final ImgRegisterService imgRegisterService;
    private final GiftCreateRequestValidator validator;


    @ApiOperation(value = "기록 저장", produces = "multipart/form-data", notes = "선물을 기록합니다.")
    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = {MediaType.MULTIPART_FORM_DATA_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@ModelAttribute("request") GiftCreateRequest giftCreateRequest, @RequestPart MultipartFile img) {
        validator.validate(giftCreateRequest);
        GiftCreateDto giftCreateDto = giftCreateDtoMapper.entityToResult(giftCreateRequest);
        giftCreateDto.setImgUrl(getFileUrl(img, giftCreateDto.getCreatedBy()));
        return giftService.createGiftInfo(giftCreateDto);
    }

    @ApiOperation(value = "기록 목록 불러오기", notes = "선물 기록 목록을 불러온다.")
    @GetMapping("/{createdBy}")
    @ResponseBody
    public GiftListResponse getGiftInfo(@PathVariable String createdBy, @RequestParam Integer page, @RequestParam Integer size) {
        return giftService.getGiftListResponse(GiftGetByCreationRequest.of(createdBy, page, size));
    }

    @ApiOperation(value = "태그 검색", notes = "태그 검색")
    @GetMapping("/{createdBy}/tag")
    @ResponseBody
    public GiftListResponse getGiftInfoByTag(@PathVariable String createdBy) {
        return null;
    }

    @ApiOperation(value = "이미지 업로드 테스트", produces = "multipart/form-data", notes = "업로드 테스트")
    @PostMapping("/testImg")
    public String testImg(@RequestParam MultipartFile img) {
        return getFileUrl(img, "test");
    }

    private String getFileUrl(MultipartFile file, String userToken) {
        return imgRegisterService.uploadImgToS3(file, userToken);
    }
}
