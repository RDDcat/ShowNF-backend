package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestImageHeartDeleteDTO;
import com.shownf.reptile.entity.ImageHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdImageDAOBean {

    // 이미지 좋아요 uId 판별
    public boolean exec(ImageHeartDAO imageHeartDAO, RequestImageHeartDeleteDTO requestImageHeartDeleteDTO){
        if (imageHeartDAO.getUId().equals(requestImageHeartDeleteDTO.getUId()))
            return true;
        return false;
    }
}
