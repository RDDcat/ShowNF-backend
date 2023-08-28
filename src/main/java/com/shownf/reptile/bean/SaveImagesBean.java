package com.shownf.reptile.bean;

import com.shownf.reptile.bean.small.CreateUniqueIdBean;
import com.shownf.reptile.bean.small.SaveImagesDAOBean;
import com.shownf.reptile.entity.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SaveImagesBean {

    @Value("${upload.directory}")
    private String uploadDirectory;

    CreateUniqueIdBean createUniqueIdBean;
    SaveImagesDAOBean saveImagesDAOBean;

    @Autowired
    public SaveImagesBean(CreateUniqueIdBean createUniqueIdBean, SaveImagesDAOBean saveImagesDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.saveImagesDAOBean = saveImagesDAOBean;
    }

    // 이미지 저장
    public void exec(List<MultipartFile> files) throws IOException {
        List<ImageDAO> imageDAOs = new ArrayList<>();

        for (MultipartFile file : files){
            String filename = file.getOriginalFilename();
            System.out.println("filename = " + filename);
            Path filePath = Paths.get(uploadDirectory + "/" + filename);

            // 이미지 파일을 static 디렉토리에 저장
            Files.copy(file.getInputStream(), filePath);

            // 이미지 아이디
            Long iId = createUniqueIdBean.exec();

            // 이미지 이름
            String imageName = file.getOriginalFilename();

            // 이미지 url
            String imageUrl = "http://localhost:8080/" + filename;

            // 업로드 시간
            LocalDateTime uploadTime = LocalDateTime.now();

            // 이미지 좋아요 갯수
            Integer heartCount = 0;

            // 이미지 DAO 저장
            imageDAOs.add(new ImageDAO(iId, imageName, imageUrl, uploadTime, heartCount));

        }

        // 이미지 저장
        saveImagesDAOBean.exec(imageDAOs);

    }
}
