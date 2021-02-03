package com.nexters.giftzip.interfaces.rest.gift.response;

import com.nexters.giftzip.interfaces.rest.gift.dto.GiftListDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftListResponse {
    private List<GiftListDto> gifts;
    private int page;
    private int size;
    private long totalCount;

    public static GiftListResponse of(List<GiftListDto> gifts, Pageable pageable, long totalCount) {
        return new GiftListResponse(gifts, pageable.getPageNumber(), pageable.getPageSize(), totalCount);
    }
}
