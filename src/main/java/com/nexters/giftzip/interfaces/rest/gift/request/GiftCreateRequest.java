package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.Reason;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private LocalDateTime receiveDate;
    @ApiModelProperty("createdBy")
    private String createdBy;
    @ApiModelProperty("category")
    private Category category;
    @ApiModelProperty("emotion")
    private Emotion emotion;
    @ApiModelProperty("reason")
    private Reason reason;
}
