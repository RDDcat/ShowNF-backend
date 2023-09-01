package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestCommentHeartDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestReplyDeleteDTO;
import com.shownf.reptile.Model.entity.CommentHeartDAO;
import com.shownf.reptile.Model.entity.ReplyDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdCommentDAOBean {

    // 댓글 좋아요 userId 판별
    public boolean exec(CommentHeartDAO commentHeartDAO, RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){
        if (commentHeartDAO.getUserId().equals(requestCommentHeartDeleteDTO.getUserId()))
            return true;
        return false;
    }

    // 대댓글 uId 판별
    public boolean exec(ReplyDAO replyDAO, RequestReplyDeleteDTO requestReplyDeleteDTO){
        if (replyDAO.getUserId().equals(requestReplyDeleteDTO.getUserId()))
            return true;
        return false;
    }
}
