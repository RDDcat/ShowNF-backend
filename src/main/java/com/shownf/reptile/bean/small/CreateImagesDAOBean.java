package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateImagesDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateImagesDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 이미지 저장시 DAO 생성
    public List<ImageDAO> exec(List<MultipartFile> files) throws IOException {
        List<ImageDAO> imageDAOs = new ArrayList<>();

        for (MultipartFile file : files){
            if (file.isEmpty())
                return null;
            else {
                // 이미지 아이디
                Long iId = createUniqueIdBean.exec();

                // 이미지 이름
                String imageName = file.getOriginalFilename();

                // 이미지 정보
                byte[] information = file.getBytes();

                // 업로드 시간
                LocalDateTime uploadTime = LocalDateTime.now();

               /* // 이미지 DAO 저장
                imageDAOs.add(new ImageDAO(iId, imageName, information, uploadTime));
       */     }
        }

        return imageDAOs;
    }
}
