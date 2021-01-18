package com.nexters.giftzip.interfaces.rest.gift;

import com.nexters.giftzip.interfaces.rest.gift.request.GiftCreateRequest;
import com.nexters.giftzip.interfaces.rest.gift.response.GiftListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gift")
@RequiredArgsConstructor
public class GiftController {
    private final GiftService giftService;

    @PostMapping("/create")
    public void save(@RequestBody GiftCreateRequest giftCreateRequest) {
        giftService.createGiftInfo(giftCreateRequest);
    }

    @GetMapping("/{createdBy}")
    @ResponseBody
    public GiftListResponse getGiftInfo(@PathVariable String createdBy) {
        return giftService.getGiftListResponse(createdBy);
    }
}
