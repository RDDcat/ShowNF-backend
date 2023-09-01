package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestReplyHeartDeleteDTO;
import com.shownf.reptile.Model.entity.ReplyHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdReplyDAOBean {

    // 대댓글 좋아요 uId 판별
    public boolean exec(ReplyHeartDAO replyHeartDAO, RequestReplyHeartDeleteDTO requestReplyHeartDeleteDTO){
        if (replyHeartDAO.getUserId().equals(requestReplyHeartDeleteDTO.getUserId()))
            return true;
        return false;
    }
}
