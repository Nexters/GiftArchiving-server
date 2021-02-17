package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.common.Order;
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
    private Order order;

    public static GiftGetByCreationRequest of(String createdBy, Integer page, Integer size, Boolean isReceivedGift, Order order) {
        if(order == null) {
            order = Order.DESC;
        }
        return new GiftGetByCreationRequest(createdBy, isReceivedGift, page, size, order);
    }

    public Predicate getPredicate() {
        QGiftInfoDocument gift = QGiftInfoDocument.giftInfoDocument;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(gift.createdBy.eq(this.createdBy));
        builder.and(gift.isReceiveGift.eq(isReceivedGift));
        return builder;
    }

    public Pageable getPageable() {
        Sort.Direction sort = order == Order.ASC ? Sort.Direction.ASC : Sort.Direction.DESC;
        return PageRequest.of(page, size, sort, "createdAt");
    }
}
