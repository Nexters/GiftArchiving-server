package com.nexters.giftzip.interfaces.rest.gift;

import com.nexters.giftzip.support.aws.AwsS3Service;
import com.nexters.giftzip.support.exception.AwsS3Exception;
import com.nexters.giftzip.support.exception.CommonErrorType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
@Slf4j
public class ImgRegisterService {
    private final AwsS3Service awsS3Supporter;

    @Value("${aws.s3.url}")
    private String s3Url;

    public ImgRegisterService(AwsS3Service awsS3Supporter) {
        this.awsS3Supporter = awsS3Supporter;
    }

    public String uploadImgToS3(MultipartFile img, String userToken) {
        try {
            String fileName = img.getOriginalFilename() + new Date().toString();
            awsS3Supporter.uploadObject(img, fileName, userToken);
            return s3Url + userToken + "/" + fileName;
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new AwsS3Exception(CommonErrorType.AWS_S3_ERROR);
        }
    }
}
