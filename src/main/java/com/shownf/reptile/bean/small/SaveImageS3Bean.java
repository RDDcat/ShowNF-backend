package com.shownf.reptile.bean.small;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.shownf.reptile.Model.entity.ImageDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SaveImageS3Bean {
    private final AmazonS3Client amazonS3Client;


    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    // Aws S3에 이미지 저장
    // 이미지 url 리턴
    // 개선가능 : String 이 아닌 클래스로 Url 리턴
    // 개선가능 : 코드 읽기 불편한거 개선 (주석, 클래스화)
    // 인터넷이 있는거 그냥 쓱 긁어 온거라 그냥 고치면됨
    public String exec(MultipartFile multipartFile) throws IOException{
        String s3FileName = "images/" + UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(multipartFile.getInputStream().available());

        PutObjectResult putObjectResult = amazonS3Client.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);

        System.out.println("putObjectResult : " + putObjectResult.toString());

        return amazonS3Client.getUrl(bucket, s3FileName).toString();

    }

}
