package com.nexters.giftzip.interfaces.rest.gift.validator;

import com.nexters.giftzip.interfaces.common.CommonValidator;
import com.nexters.giftzip.interfaces.common.entity.user.UserService;
import com.nexters.giftzip.support.exception.CommonErrorType;
import com.nexters.giftzip.support.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GiftGetRequestValidator implements CommonValidator<String> {
    private final UserService userService;

    @Override
    public void validate(String s) {
        validateStringIsEmpty(s);
        if(!userService.findByToken(s).isPresent()) {
            throw new NotFoundException(CommonErrorType.USER_NOT_FOUND);
        }
    }
}
