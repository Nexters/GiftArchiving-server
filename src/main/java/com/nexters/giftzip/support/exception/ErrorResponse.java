package com.nexters.giftzip.support.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String reason;

    private ErrorResponse(int errorCode, String reason) {
        this.errorCode = errorCode;
        this.reason = reason;
    }

    public static ErrorResponse of(int errorCode, String reason) {
        return new ErrorResponse(errorCode, reason);
    }
}
