package com.shownf.reptile.service;

import com.shownf.reptile.bean.SaveImagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    SaveImagesBean saveImageBean;

    @Autowired
    public ImageService(SaveImagesBean saveImageBean) {
        this.saveImageBean = saveImageBean;
    }

    // 이미지 저장
    public void saveImage(List<MultipartFile> files) throws IOException {
        saveImageBean.exec(files);
    }
}
