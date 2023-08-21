package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentDeleteDTO;
import com.shownf.reptile.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.entity.CommentDAO;
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

    // 댓글 pId 판별
    public boolean exec(CommentDAO commentDAO, RequestCommentDeleteDTO requestCommentDeleteDTO){
        if (commentDAO.getPId().equals(requestPostHeartDeleteDTO.getPId()))
            return true;
        return false;
    }
}
