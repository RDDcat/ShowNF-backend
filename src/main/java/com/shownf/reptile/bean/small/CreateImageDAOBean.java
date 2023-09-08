package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.Model.entity.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CreateImageDAOBean {
    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateImageDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 이미지 생성시 DAO 저장
    public ImageDAO exec(MultipartFile file, String imageUrl) throws IOException {

        // 이미지 아이디
        Long imageId = createUniqueIdBean.exec();

        // 이미지 이름
        String imageName = file.getOriginalFilename();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // 이미지 좋아요 갯수
        Integer heartCount = 0;

        // 이미지 DAO 리턴
        return new ImageDAO(imageId, imageName, imageUrl, uploadTime, heartCount);

    }

}
