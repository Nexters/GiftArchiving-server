package com.nexters.giftzip.interfaces.rest.user.request;

import com.nexters.giftzip.interfaces.common.entity.user.LoginType;
import lombok.Getter;

@Getter
public class UserSignInRequest {
    private String name;
    private String token;
    private LoginType loginType;
}
