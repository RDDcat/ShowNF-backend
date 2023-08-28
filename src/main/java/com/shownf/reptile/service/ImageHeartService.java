package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestImageHeartSaveDTO;
import com.shownf.reptile.bean.SaveImageHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageHeartService {

    SaveImageHeartBean saveImageHeartBean;

    @Autowired
    public ImageHeartService(SaveImageHeartBean saveImageHeartBean) {
        this.saveImageHeartBean = saveImageHeartBean;
    }

    // 이미지 좋아요 저장
    public Long saveImageHeart(RequestImageHeartSaveDTO requestImageHeartSaveDTO){
        return saveImageHeartBean.exec(requestImageHeartSaveDTO);
    }

    // 이미지 좋아요 삭제
}
