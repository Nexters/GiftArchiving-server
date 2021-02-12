package com.nexters.giftzip.interfaces.rest.gift.validator;

import com.nexters.giftzip.interfaces.common.CommonValidator;
import com.nexters.giftzip.interfaces.common.entity.user.UserDocument;
import com.nexters.giftzip.interfaces.common.entity.user.UserRepository;
import com.nexters.giftzip.interfaces.common.entity.user.UserService;
import com.nexters.giftzip.interfaces.rest.gift.request.GiftCreateRequest;
import com.nexters.giftzip.support.exception.CommonErrorType;
import com.nexters.giftzip.support.exception.NotFoundException;
import com.nexters.giftzip.support.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GiftCreateRequestValidator implements CommonValidator<GiftCreateRequest> {
    private final UserService userService;

    public void validate(GiftCreateRequest request) {
        validateStringIsEmpty(request.getCreatedBy());

        if(!userService.findByToken(request.getCreatedBy()).isPresent()) {
            throw new NotFoundException(CommonErrorType.USER_NOT_FOUND);
        }
    }
}
