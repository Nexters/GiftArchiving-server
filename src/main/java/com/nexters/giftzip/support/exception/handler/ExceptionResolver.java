package com.nexters.giftzip.support.exception.handler;

import com.nexters.giftzip.support.exception.AwsS3Exception;
import com.nexters.giftzip.support.exception.NotFoundException;
import com.nexters.giftzip.support.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionResolver {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ErrorResponse handleNotFoundException(NotFoundException e, HttpServletRequest request) {
        return ErrorResponse.of(e.getErrorType().getErrorCode(), e.getErrorType().getDesc());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AwsS3Exception.class)
    @ResponseBody
    public ErrorResponse handleS3Exception(AwsS3Exception e) {
        return ErrorResponse.of(e.getErrorType().getErrorCode(), e.getErrorType().getDesc());
    }
}
