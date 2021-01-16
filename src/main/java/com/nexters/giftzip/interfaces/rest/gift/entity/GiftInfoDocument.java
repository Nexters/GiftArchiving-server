package com.nexters.giftzip.interfaces.rest.gift.entity;

import com.nexters.giftzip.interfaces.rest.common.BaseEntity;
import com.nexters.giftzip.interfaces.rest.common.tag.Category;
import com.nexters.giftzip.interfaces.rest.common.tag.Emotion;
import com.nexters.giftzip.interfaces.rest.common.tag.FrameSort;
import com.nexters.giftzip.interfaces.rest.common.tag.StickerSort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "gift_info")
public class GiftInfoDocument extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -7933357496659182557L;

    @MongoId
    private String id;
    private String content;
    private Boolean isReceiveGift;
    private String name;
    private LocalDateTime receiveDate;
    private String imgUrl;
    private String bgColor;
    private FrameSort frameSort;
    private List<Sticker> sticker;
    private Category category;
    private Emotion emotion;
    private StickerSort stickerSort;
}
