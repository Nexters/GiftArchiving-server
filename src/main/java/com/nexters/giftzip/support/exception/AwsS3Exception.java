package com.nexters.giftzip.support.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AwsS3Exception extends RuntimeException{
    private CommonErrorType errorType;

    public AwsS3Exception(CommonErrorType commonErrorType){
        super(commonErrorType.getDesc());
        this.errorType = commonErrorType;
    }
}
