package com.nexters.giftzip.support.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CommonErrorType {
    //400
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, -400, "요청하는 값이 존재하지 않습니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, -401, "사용자가 존재하지 않습니다."),

    //500
    AWS_S3_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, -501, "S3 파일 업로드가 실패하였습니다."),

    //600(validateion Exception)
    COLLECTION_IS_EMPTY(HttpStatus.BAD_REQUEST, -601, "list가 비어있습니다."),
    NUMBER_IS_NULL_OR_ZERO(HttpStatus.BAD_REQUEST, -602, "number가 0이나 null입니다."),
    OBJECT_IS_NULL(HttpStatus.BAD_REQUEST, -603, "object가 null입니다."),
    STRING_IS_EMPTY(HttpStatus.BAD_REQUEST, -604, "string이 null입니다.")
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
