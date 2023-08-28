package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestImageHeartDeleteDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.ImageDAO;
import com.shownf.reptile.entity.ImageHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteImageHeartBean {

    GetImageHeartDAOBean getImageHeartDAOBean;
    CheckImageIdImageDAOBean checkImageIdImageDAOBean;
    CheckUserIdImageDAOBean checkUserIdImageDAOBean;
    DeleteImageHeartDAOBean deleteImageHeartDAOBean;
    UpdateImageHeartCountDAOBean updateImageHeartCountDAOBean;
    SaveImageDAOBean saveImageDAOBean;

    @Autowired
    public DeleteImageHeartBean(GetImageHeartDAOBean getImageHeartDAOBean, CheckImageIdImageDAOBean checkImageIdImageDAOBean, CheckUserIdImageDAOBean checkUserIdImageDAOBean, DeleteImageHeartDAOBean deleteImageHeartDAOBean, UpdateImageHeartCountDAOBean updateImageHeartCountDAOBean, SaveImageDAOBean saveImageDAOBean) {
        this.getImageHeartDAOBean = getImageHeartDAOBean;
        this.checkImageIdImageDAOBean = checkImageIdImageDAOBean;
        this.checkUserIdImageDAOBean = checkUserIdImageDAOBean;
        this.deleteImageHeartDAOBean = deleteImageHeartDAOBean;
        this.updateImageHeartCountDAOBean = updateImageHeartCountDAOBean;
        this.saveImageDAOBean = saveImageDAOBean;
    }

    // 이미지 좋아요 삭제
    public Long exec(RequestImageHeartDeleteDTO requestImageHeartDeleteDTO){

        // 이미지 좋아요 아이디 찾기
        Long iHId = requestImageHeartDeleteDTO.getIHId();

        // 아이디로 삭제할 좋아요 찾기
        ImageHeartDAO imageHeartDAO = getImageHeartDAOBean.exec(iHId);

        // 이미지 좋아요 해당하는 이미지 확인
        if (!checkImageIdImageDAOBean.exec(imageHeartDAO, requestImageHeartDeleteDTO))
            return null;

        // 이미지 좋아요 해당하는 유저 확인
        if (!checkUserIdImageDAOBean.exec(imageHeartDAO, requestImageHeartDeleteDTO))
            return null;

        // 이미지 좋아요 삭제
        deleteImageHeartDAOBean.exec(imageHeartDAO);

        // 이미지 좋아요 갯수 감소
        ImageDAO imageDAO = updateImageHeartCountDAOBean.exec(iHId, imageHeartDAO);

        // 이미지 저장
        saveImageDAOBean.exec(imageDAO);

        // iHId 반환
        return iHId;
    }
}
