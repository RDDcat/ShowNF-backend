package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestImageDTO;
import com.shownf.reptile.bean.GetImagesBean;
import com.shownf.reptile.bean.SaveImagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    SaveImagesBean saveImageBean;
    GetImagesBean getImagesBean;

    @Autowired
    public ImageService(SaveImagesBean saveImageBean, GetImagesBean getImagesBean) {
        this.saveImageBean = saveImageBean;
        this.getImagesBean = getImagesBean;
    }

    // 이미지 시간으로 전체 조회
    public Page<RequestImageDTO> getImages(Pageable pageable){
        return getImagesBean.exec(pageable);
    }

    // 이미지 저장
    public void saveImage(List<MultipartFile> files) throws IOException {
        saveImageBean.exec(files);
    }
}
