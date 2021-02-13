package com.nexters.giftzip.interfaces.rest.gift.request;

import com.nexters.giftzip.interfaces.common.tag.Category;
import com.nexters.giftzip.interfaces.common.tag.Emotion;
import com.nexters.giftzip.interfaces.common.tag.Reason;
import com.nexters.giftzip.interfaces.common.entity.gift.QGiftInfoDocument;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.Builder;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

@Builder
public class GiftTagSearchSpecification implements SpecificationRequest{
    private Category category;
    private Emotion emotion;
    private Reason reason;
    private String name;
    private String content;
    private int page;
    private int size;
    private String createdBy;

    public Predicate getPredicate() {
        QGiftInfoDocument gift = QGiftInfoDocument.giftInfoDocument;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(gift.createdBy.eq(createdBy));
        if(!Objects.isNull(category)) {
            builder.and(gift.category.eq(category));
        }
        if(!Objects.isNull(emotion)) {
            builder.and(gift.emotion.eq(emotion));
        }
        if(!Objects.isNull(reason)) {
            builder.and(gift.reason.eq(reason));
        }
        if(Strings.isNotEmpty(name)) {
            builder.and(gift.name.contains(name));
        }
        if(Strings.isNotEmpty(content)) {
            builder.and(gift.content.contains(content));
        }

        return builder;
    }

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }
}
