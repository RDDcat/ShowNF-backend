package com.shownf.reptile.bean;

import com.shownf.reptile.bean.small.CreateImagesDAOBean;
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
public class SaveImageBean {

    @Value("${upload.directory}")
    private String uploadDirectory;

    CreateUniqueIdBean createUniqueIdBean;
    CreateImagesDAOBean createImagesDAOBean;
    SaveImagesDAOBean saveImagesDAOBean;

    @Autowired
    public SaveImageBean(CreateUniqueIdBean createUniqueIdBean, CreateImagesDAOBean createImagesDAOBean, SaveImagesDAOBean saveImagesDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createImagesDAOBean = createImagesDAOBean;
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

            /*// 이미지 정보
            byte[] information = file.getBytes();*/

            // 업로드 시간
            LocalDateTime uploadTime = LocalDateTime.now();

            // 이미지 DAO 저장
            imageDAOs.add(new ImageDAO(iId, imageName, "/static/" + filename, uploadTime));


        }

       /* String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDirectory + "/" + filename);

        // 이미지 파일을 static 디렉토리에 저장
        Files.copy(file.getInputStream(), filePath);

        return "/static/" + filename;

        // File 객체 DAO 변환
        List<ImageDAO> imageDAOs = createImagesDAOBean.exec(files);*/

        // 이미지 저장
        saveImagesDAOBean.exec(imageDAOs);

        /*// 이미지 id 반환
        return iId;*/

    }
}
