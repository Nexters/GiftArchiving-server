package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.common.Order;
import com.nexters.giftzip.interfaces.common.tag.Category;
import com.nexters.giftzip.interfaces.common.tag.Emotion;
import com.nexters.giftzip.interfaces.common.tag.Reason;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@ApiModel
public class GiftTagSearchRequest {
    @ApiModelProperty("category")
    private Category category;
    @ApiModelProperty("emotion")
    private Emotion emotion;
    @ApiModelProperty("reason")
    private Reason reason;
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("content")
    private String content;
    @ApiModelProperty("page")
    private int page;
    @ApiModelProperty("size")
    private int size;
    @ApiModelProperty("order")
    private Order order;
}
