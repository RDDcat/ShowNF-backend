package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestReplyHeartDeleteDTO;
import com.shownf.reptile.entity.ReplyHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckReplyIdReplyDAOBean {

    // 대댓글 좋아요 rId 판별
    public boolean exec(ReplyHeartDAO replyHeartDAO, RequestReplyHeartDeleteDTO requestReplyHeartDeleteDTO){
        if (replyHeartDAO.getReplyId().equals(requestReplyHeartDeleteDTO.getReplyId()))
            return true;
        return false;
    }
}
