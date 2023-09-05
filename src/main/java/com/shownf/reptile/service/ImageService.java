package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestImageDTO;
import com.shownf.reptile.Model.DTO.ResponseImagesDTO;
import com.shownf.reptile.bean.GetImagesBean;
import com.shownf.reptile.bean.GetUserImageHeartsBean;
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
    GetUserImageHeartsBean getUserImageHeartsBean;
    GetImagesBean getImagesBean;

    @Autowired
    public ImageService(SaveImagesBean saveImageBean, GetUserImageHeartsBean getUserImageHeartsBean, GetImagesBean getImagesBean) {
        this.saveImageBean = saveImageBean;
        this.getUserImageHeartsBean = getUserImageHeartsBean;
        this.getImagesBean = getImagesBean;
    }

    // 이미지 시간으로 전체 조회
    public Page<RequestImageDTO> getImages(Pageable pageable){
        return getImagesBean.exec(pageable);
    }

    // 유저가 좋아요한 이미지 조회
    public List<ResponseImagesDTO> getUserImageHearts(String userId){
        return getUserImageHeartsBean.exec(userId);
    }


    // 이미지 저장
    public void saveImage(List<MultipartFile> files) throws IOException {
        saveImageBean.exec(files);
    }
}
