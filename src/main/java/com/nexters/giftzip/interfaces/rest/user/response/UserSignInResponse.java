package com.nexters.giftzip.interfaces.rest.user.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSignInResponse {
    private Integer code;
    private String message;

    public static UserSignInResponse success() {
        return  new UserSignInResponse(Status.SUCCESS.code, Status.SUCCESS.name());
    }

    public enum Status {
        SUCCESS(0), FAIL(-1);

        private int code;

        private Status(int code) {
            this.code = code;
        }
    }
}
