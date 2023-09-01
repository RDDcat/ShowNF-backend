package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestCommentHeartDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestReplyDeleteDTO;
import com.shownf.reptile.Model.entity.CommentHeartDAO;
import com.shownf.reptile.Model.entity.ReplyDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckCommentIdCommentDAOBean {

    // 좋아요 commentId 판별
    public boolean exec(CommentHeartDAO commentHeartDAO, RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){
        if (commentHeartDAO.getCommentId().equals(requestCommentHeartDeleteDTO.getCommentId()))
            return true;
        return false;
    }

    // 대댓글 commentId 판별
    public boolean exec(ReplyDAO replyDAO, RequestReplyDeleteDTO requestReplyDeleteDTO){
        if (replyDAO.getCommentId().equals(requestReplyDeleteDTO.getCommentId()))
            return true;
        return false;
    }
}
