package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentHeartDeleteDTO;
import com.shownf.reptile.entity.CommentHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckCommentIdCommentDAOBean {

    // 좋아요 cId 판별
    public boolean exec(CommentHeartDAO commentHeartDAO, RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){
        if (commentHeartDAO.getCId().equals(requestCommentHeartDeleteDTO.getCId()))
            return true;
        return false;
    }
}
