package com.nexters.giftzip.interfaces.rest.admin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nexters.giftzip.interfaces.common.entity.admin.AdminDocument;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AdminNoticeListDto {
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public static AdminNoticeListDto convert(AdminDocument adminDocument) {
        return AdminNoticeListDto.builder()
                .content(adminDocument.getContent())
                .title(adminDocument.getTitle())
                .createdAt(adminDocument.getCreatedAt())
                .build();
    }
}
