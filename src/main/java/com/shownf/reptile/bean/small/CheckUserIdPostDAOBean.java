package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestCommentDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.Model.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdPostDAOBean {

    /*// 게시물 uId 판별
    public boolean exec(PostDAO postDAO, String uId){
        if(postDAO.getUId().equals(uId))
            return true;
        return false;
    }*/

    // 좋아요 userId 판별
    public boolean exec(PostHeartDAO postHeartDAO, RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){
        if (postHeartDAO.getUserId().equals(requestPostHeartDeleteDTO.getUserId()))
            return true;
        return false;
    }

    // 댓글 uId 판별
    public boolean exec(CommentDAO commentDAO, RequestCommentDeleteDTO requestCommentDeleteDTO){
        if (commentDAO.getUserId().equals(requestCommentDeleteDTO.getUserId()))
            return true;
        return false;
    }
}
