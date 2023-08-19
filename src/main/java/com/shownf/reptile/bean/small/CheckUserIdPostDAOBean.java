package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdPostDAOBean {

    // 게시물 uId 판별
    public boolean exec(PostDAO postDAO, String uId){
        if(postDAO.getUId().equals(uId))
            return true;
        return false;
    }
}
