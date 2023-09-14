package com.shownf.reptile.bean;

import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.Model.entity.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class SaveImageBean {
    SaveImageS3Bean saveImageS3Bean;
    CreateImageDAOBean createImageDAOBean;
    SaveImageDAOBean saveImageDAOBean;

    @Autowired
    public SaveImageBean(SaveImageS3Bean saveImageS3Bean, CreateImageDAOBean createImageDAOBean, SaveImageDAOBean saveImageDAOBean) {
        this.saveImageS3Bean = saveImageS3Bean;
        this.createImageDAOBean = createImageDAOBean;
        this.saveImageDAOBean = saveImageDAOBean;
    }

    // 이미지 저장
    public String exec(MultipartFile file) throws IOException {

        // 이미지 저장
        // List<String> imageUrls = saveImagesS3Bean.exec(files.get(0));
        String imageUrls = saveImageS3Bean.exec(file);

        // 이미지 DAO 생성
        ImageDAO imageDAO = createImageDAOBean.exec(file, imageUrls);

        // 이미지 DAO 저장
        saveImageDAOBean.exec(imageDAO);

        // 이미지 Url 반환
        return imageDAO.getImageUrl();
    }
}
