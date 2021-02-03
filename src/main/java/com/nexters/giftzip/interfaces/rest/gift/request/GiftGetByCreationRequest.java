package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.rest.gift.entity.QGiftInfoDocument;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GiftGetByCreationRequest {
    private String createdBy;
    private Pageable pageable;

    public static GiftGetByCreationRequest of(String createdBy, Integer page, Integer size) {
        return new GiftGetByCreationRequest(createdBy, PageRequest.of(page, size));
    }

    public Predicate getPredicate() {
        QGiftInfoDocument gift = QGiftInfoDocument.giftInfoDocument;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(gift.createdBy.eq(this.createdBy));
        return builder;
    }
}
