package com.nexters.giftzip.interfaces.common.entity.user;

import com.nexters.giftzip.interfaces.common.entity.gift.GiftInfoRepository;
import com.nexters.giftzip.interfaces.rest.gift.GiftInfoService;
import com.nexters.giftzip.interfaces.rest.user.request.UserSignInRequest;
import com.nexters.giftzip.support.exception.CommonErrorType;
import com.nexters.giftzip.support.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final GiftInfoRepository giftInfoRepository;

    @Transactional
    public void signInUser(UserSignInRequest request){
        UserDocument userDocument = new UserDocument();
        userDocument.setToken(request.getToken());
        userDocument.setLoginType(request.getLoginType());
        userRepository.save(userDocument);
    }

    public Optional<UserDocument> findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Transactional
    public void withdrawal(String token) {
        userRepository.deleteById(token);
        giftInfoRepository.deleteByCreatedBy(token);
    }
}
