package com.nexters.giftzip.interfaces.rest.user;

import com.nexters.giftzip.interfaces.rest.user.entity.UserDocument;
import com.nexters.giftzip.interfaces.rest.user.entity.UserRepository;
import com.nexters.giftzip.interfaces.rest.user.request.UserSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void signInUser(UserSignInRequest request){
        UserDocument userDocument = new UserDocument();
        userDocument.setToken(request.getAppleToken());
        userRepository.save(userDocument);
    }
}
