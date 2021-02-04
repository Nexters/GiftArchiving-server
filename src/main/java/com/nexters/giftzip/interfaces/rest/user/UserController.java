package com.nexters.giftzip.interfaces.rest.user;

import com.nexters.giftzip.interfaces.rest.user.request.UserSignInRequest;
import com.nexters.giftzip.interfaces.rest.user.response.UserSignInResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "토큰값을 저장합니다.")
    @PostMapping("/signIn")
    public UserSignInResponse kakaoSignIn(@RequestBody UserSignInRequest request) {
        userService.signInUser(request);
        return UserSignInResponse.success();
    }
}
