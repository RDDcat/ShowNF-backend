package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestImageHeartDeleteDTO;
import com.shownf.reptile.Model.entity.ImageHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckImageIdImageDAOBean {

    // 좋아요 iId 판별
    public boolean exec(ImageHeartDAO imageHeartDAO, RequestImageHeartDeleteDTO requestImageHeartDeleteDTO){
        if (imageHeartDAO.getImageId().equals(requestImageHeartDeleteDTO.getImageId()))
            return true;
        return false;
    }
}
