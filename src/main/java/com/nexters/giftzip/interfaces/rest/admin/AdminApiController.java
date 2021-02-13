package com.nexters.giftzip.interfaces.rest.admin;

import com.nexters.giftzip.interfaces.common.entity.admin.AdminService;
import com.nexters.giftzip.interfaces.common.entity.admin.AdminDocument;
import com.nexters.giftzip.interfaces.rest.admin.dto.AdminNoticeListDto;
import com.nexters.giftzip.interfaces.rest.admin.response.AdminNoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminApiController {
    private final AdminService adminService;

    @GetMapping
    public AdminNoticeResponse getNotice() {
        List<AdminDocument> adminList = adminService.getAdminList();
        List<AdminNoticeListDto> noticeList = adminList.stream()
                .map(AdminNoticeListDto::convert)
                .collect(Collectors.toList());
        return AdminNoticeResponse.of(noticeList);
    }

}
