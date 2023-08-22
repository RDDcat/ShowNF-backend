package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentHeartDeleteDTO;
import com.shownf.reptile.entity.CommentHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdCommentDAOBean {

    // 댓글 좋아요 uId 판별
    public boolean exec(CommentHeartDAO commentHeartDAO, RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){
        if (commentHeartDAO.getUId().equals(requestCommentHeartDeleteDTO.getUId()))
            return true;
        return false;
    }
}
