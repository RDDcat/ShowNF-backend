package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestImageHeartDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestImageHeartSaveDTO;
import com.shownf.reptile.bean.DeleteImageHeartBean;
import com.shownf.reptile.bean.SaveImageHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageHeartService {

    SaveImageHeartBean saveImageHeartBean;
    DeleteImageHeartBean deleteImageHeartBean;

    @Autowired
    public ImageHeartService(SaveImageHeartBean saveImageHeartBean, DeleteImageHeartBean deleteImageHeartBean) {
        this.saveImageHeartBean = saveImageHeartBean;
        this.deleteImageHeartBean = deleteImageHeartBean;
    }

    // 이미지 좋아요 저장
    public Long saveImageHeart(RequestImageHeartSaveDTO requestImageHeartSaveDTO){
        return saveImageHeartBean.exec(requestImageHeartSaveDTO);
    }

    // 이미지 좋아요 삭제
    public Long deleteImageHeart(RequestImageHeartDeleteDTO requestImageHeartDeleteDTO){
        return deleteImageHeartBean.exec(requestImageHeartDeleteDTO);
    }
}
