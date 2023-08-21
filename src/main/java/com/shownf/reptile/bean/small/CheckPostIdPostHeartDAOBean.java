package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckPostIdPostHeartDAOBean {

    // 좋아요 pId 판별
    public boolean exec(PostHeartDAO postHeartDAO, RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){
        if (postHeartDAO.getPId().equals(requestPostHeartDeleteDTO.getPId()))
            return true;
        return false;
    }
}
