package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestImageHeartDeleteDTO;
import com.shownf.reptile.Model.entity.ImageHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdImageDAOBean {

    // 이미지 좋아요 uId 판별
    public boolean exec(ImageHeartDAO imageHeartDAO, RequestImageHeartDeleteDTO requestImageHeartDeleteDTO){
        if (imageHeartDAO.getUserId().equals(requestImageHeartDeleteDTO.getUserId()))
            return true;
        return false;
    }
}
