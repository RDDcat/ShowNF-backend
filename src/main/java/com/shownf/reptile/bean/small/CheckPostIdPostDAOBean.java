package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestCommentDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.Model.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckPostIdPostDAOBean {

    // 좋아요 postId 판별
    public boolean exec(PostHeartDAO postHeartDAO, RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){
        if (postHeartDAO.getPostId().equals(requestPostHeartDeleteDTO.getPostId()))
            return true;
        return false;
    }

    // 댓글 postId 판별
    public boolean exec(CommentDAO commentDAO, RequestCommentDeleteDTO requestCommentDeleteDTO){
        if (commentDAO.getPostId().equals(requestCommentDeleteDTO.getPostId()))
            return true;
        return false;
    }
}
