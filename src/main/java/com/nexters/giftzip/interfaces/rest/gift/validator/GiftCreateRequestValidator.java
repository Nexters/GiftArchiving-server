package com.nexters.giftzip.interfaces.rest.gift.validator;

import com.nexters.giftzip.interfaces.rest.gift.request.GiftCreateRequest;
import com.nexters.giftzip.support.exception.CommonErrorType;
import com.nexters.giftzip.support.exception.ValidationException;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class GiftCreateRequestValidator {

    public void validate(GiftCreateRequest request) {
        if(StringUtils.isEmpty(request.getCreatedBy())) {
            throw new ValidationException(CommonErrorType.DATA_NOT_FOUND);
        }
    }
}
