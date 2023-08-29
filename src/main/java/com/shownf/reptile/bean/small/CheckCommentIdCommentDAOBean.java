package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentHeartDeleteDTO;
import com.shownf.reptile.DTO.RequestReplyDeleteDTO;
import com.shownf.reptile.entity.CommentHeartDAO;
import com.shownf.reptile.entity.ReplyDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckCommentIdCommentDAOBean {

    // 좋아요 commentId 판별
    public boolean exec(CommentHeartDAO commentHeartDAO, RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){
        if (commentHeartDAO.getCId().equals(requestCommentHeartDeleteDTO.getCId()))
            return true;
        return false;
    }

    // 대댓글 commentId 판별
    public boolean exec(ReplyDAO replyDAO, RequestReplyDeleteDTO requestReplyDeleteDTO){
        if (replyDAO.getCId().equals(requestReplyDeleteDTO.getCId()))
            return true;
        return false;
    }
}
