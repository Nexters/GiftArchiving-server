package com.nexters.giftzip.interfaces.rest.gift.request;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

public interface SpecificationRequest {
    Predicate getPredicate();
    Pageable getPageable();
}
