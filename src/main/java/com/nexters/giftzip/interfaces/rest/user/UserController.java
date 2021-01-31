package com.nexters.giftzip.interfaces.rest.user;

import com.nexters.giftzip.interfaces.rest.user.request.UserSignInRequest;
import com.nexters.giftzip.interfaces.rest.user.response.UserSignInResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "카카오 회원가입", notes = "카카오톡 로그인의 토큰값을 저장합니다.")
    @PostMapping("/kakao/signIn")
    public UserSignInResponse kakaoSignin(@RequestBody UserSignInRequest request) {
        userService.signInUser(request);
        return UserSignInResponse.success();
    }
}
