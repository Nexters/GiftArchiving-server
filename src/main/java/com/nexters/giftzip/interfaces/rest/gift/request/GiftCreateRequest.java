package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameType;
import com.nexters.giftzip.interfaces.rest.gift.entity.Sticker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

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
    @ApiModelProperty("bgColor")
    private String bgColor;
    @ApiModelProperty("frameType")
    private FrameType frameType;
    @ApiModelProperty("createdBy")
    private String createdBy;
    @ApiModelProperty("category")
    private Category category;
    @ApiModelProperty("emotion")
    private Emotion emotion;
}
