package com.nexters.giftzip.interfaces.rest.user.request;

import com.nexters.giftzip.interfaces.rest.user.entity.LoginType;
import lombok.Getter;

@Getter
public class UserSignInRequest {
    private String name;
    private String kakaoToken;
    private String appleToken;
    private LoginType loginType;
}
