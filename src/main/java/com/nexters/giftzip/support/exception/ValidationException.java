package com.nexters.giftzip.support.exception;

public class ValidationException extends RuntimeException implements HandleException{
    private CommonErrorType errorType;
    public ValidationException(CommonErrorType errorType) {
        super(errorType.getDesc());
        this.errorType = errorType;
    }

    @Override
    public CommonErrorType getCommonErrorType() {
        return errorType;
    }
}
