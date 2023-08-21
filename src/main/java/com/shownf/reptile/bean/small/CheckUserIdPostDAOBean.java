package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentDeleteDTO;
import com.shownf.reptile.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.entity.CommentDAO;
import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdPostDAOBean {

    // 게시물 uId 판별
    public boolean exec(PostDAO postDAO, String uId){
        if(postDAO.getUId().equals(uId))
            return true;
        return false;
    }

    // 좋아요 uId 판별
    public boolean exec(PostHeartDAO postHeartDAO, RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){
        if (postHeartDAO.getUId().equals(requestPostHeartDeleteDTO.getUId()))
            return true;
        return false;
    }

    // 댓글 uId 판별
    public boolean exec(CommentDAO commentDAO, RequestCommentDeleteDTO requestCommentDeleteDTO){
        if (commentDAO.getUId().equals(requestCommentDeleteDTO.getUId()))
            return true;
        return false;
    }
}
