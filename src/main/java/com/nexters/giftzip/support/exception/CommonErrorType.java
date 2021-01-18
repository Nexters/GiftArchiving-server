package com.nexters.giftzip.support.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CommonErrorType {
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, -400, "요청하는 값이 존재하지 않습니다"),

    ;


    private HttpStatus status;
    private int errorCode;
    private String desc;

    CommonErrorType(HttpStatus status, int errorCode, String desc) {
        this.status = status;
        this.errorCode = errorCode;
        this.desc = desc;
    }
}
