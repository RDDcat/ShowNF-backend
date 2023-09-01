package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestImageHeartSaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.Model.entity.ImageHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveImageHeartBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateImageHeartDAOBean createImageHeartDAOBean;
    SaveImageHeartDAOBean saveImageHeartDAOBean;
    UpdateImageHeartCountDAOBean updateImageHeartCountDAOBean;
    SaveImageDAOBean saveImageDAOBean;

    @Autowired
    public SaveImageHeartBean(CreateUniqueIdBean createUniqueIdBean, CreateImageHeartDAOBean createImageHeartDAOBean, SaveImageHeartDAOBean saveImageHeartDAOBean, UpdateImageHeartCountDAOBean updateImageHeartCountDAOBean, SaveImageDAOBean saveImageDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createImageHeartDAOBean = createImageHeartDAOBean;
        this.saveImageHeartDAOBean = saveImageHeartDAOBean;
        this.updateImageHeartCountDAOBean = updateImageHeartCountDAOBean;
        this.saveImageDAOBean = saveImageDAOBean;
    }

    // 이미지 좋아요 저장
    public Long exec(RequestImageHeartSaveDTO requestImageHeartSaveDTO){

        // imageHeartId 생성
        Long imageHeartId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        ImageHeartDAO imageHeartDAO = createImageHeartDAOBean.exec(imageHeartId, requestImageHeartSaveDTO);

        // 이미지 좋아요 저장
        saveImageHeartDAOBean.exec(imageHeartDAO);

        // 이미지 좋아요 갯수 추가
        ImageDAO imageDAO = updateImageHeartCountDAOBean.exec(imageHeartDAO);

        // 이미지 저장
        saveImageDAOBean.exec(imageDAO);

        // imageHeartId 반환
        return imageHeartId;
    }
}
