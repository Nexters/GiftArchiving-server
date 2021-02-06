package com.nexters.giftzip.support.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Component
public class AwsS3Service {
    private AmazonS3 s3Client;

    @Value("${aws.bucket.name}")
    private String bucketName;

    public AwsS3Service(@Value("${cloud.aws.credentials.access-key}") String accessKey, @Value("${cloud.aws.credentials.secret-key}") String secretKey){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_NORTHEAST_2)
                .enableForceGlobalBucketAccess()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }

    public void uploadObject(MultipartFile multipartFile, String storedFileName, String userToken) throws IOException {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/png");
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentDisposition("inline");

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName+"/"+userToken,
                storedFileName, multipartFile.getInputStream(), objectMetadata);
        s3Client.putObject(putObjectRequest);
    }

    public void deleteObject(String storedFileName) throws AmazonServiceException {
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName + "/", storedFileName);

        log.info("AWS S3 DELETE ::  bucket :{}, fileName : {}", deleteObjectRequest.getBucketName(), storedFileName);
        s3Client.deleteObject(deleteObjectRequest);
    }

}
