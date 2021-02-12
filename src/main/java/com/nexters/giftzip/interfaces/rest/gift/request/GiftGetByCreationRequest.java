package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.common.entity.gift.QGiftInfoDocument;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftGetByCreationRequest implements SpecificationRequest{
    private String createdBy;
    private Boolean isReceivedGift;
    private int page;
    private int size;

    public static GiftGetByCreationRequest of(String createdBy, Integer page, Integer size, Boolean isReceivedGift) {
        return new GiftGetByCreationRequest(createdBy, isReceivedGift, page, size);
    }

    public Predicate getPredicate() {
        QGiftInfoDocument gift = QGiftInfoDocument.giftInfoDocument;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(gift.createdBy.eq(this.createdBy));
        builder.and(gift.isReceiveGift.eq(isReceivedGift));
        return builder;
    }

    public Pageable getPageable() {
        return PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
    }
}
