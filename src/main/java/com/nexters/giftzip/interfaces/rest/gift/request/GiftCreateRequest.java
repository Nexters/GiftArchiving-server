package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.common.tag.Category;
import com.nexters.giftzip.interfaces.common.tag.Emotion;
import com.nexters.giftzip.interfaces.common.tag.FrameType;
import com.nexters.giftzip.interfaces.common.tag.Reason;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Getter
@NoArgsConstructor
@ApiModel
public class GiftCreateRequest {
    @ApiModelProperty("content")
    private String content;
    @ApiModelProperty("isReceiveGift")
    private Boolean isReceiveGift;
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("receiveDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime receiveDate;
    @ApiModelProperty("createdBy")
    private String createdBy;
    @ApiModelProperty("category")
    private Category category;
    @ApiModelProperty("emotion")
    private Emotion emotion;
    @ApiModelProperty("reason")
    private Reason reason;
    @ApiModelProperty("bgColor")
    private String bgColor;
    @ApiModelProperty("frameType")
    private FrameType frameType;
}
