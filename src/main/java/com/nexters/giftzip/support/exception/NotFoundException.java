package com.nexters.giftzip.support.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private CommonErrorType errorType;

    public NotFoundException(CommonErrorType commonErrorType) {
        super(commonErrorType.getDesc());
        this.errorType = commonErrorType;
    }
}
