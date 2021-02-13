package com.nexters.giftzip.interfaces.rest.admin.response;

import com.nexters.giftzip.interfaces.rest.admin.dto.AdminNoticeListDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminNoticeResponse {
    private List<AdminNoticeListDto> noticeList;

    public static AdminNoticeResponse of(List<AdminNoticeListDto> noticeList) {
        return new AdminNoticeResponse(noticeList);
    }
}
