package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdPostHeartDAOBean {

    // 좋아요 uId 판별
    public boolean exec(PostHeartDAO postHeartDAO, RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){
        if (postHeartDAO.getUId().equals(requestPostHeartDeleteDTO.getUId()))
            return true;
        return false;
    }
}
