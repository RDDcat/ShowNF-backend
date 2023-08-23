package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestReplyHeartDeleteDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.ReplyDAO;
import com.shownf.reptile.entity.ReplyHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReplyHeartBean {

    GetReplyHeartDAOBean getReplyHeartDAOBean;
    CheckReplyIdReplyDAOBean checkReplyIdReplyDAOBean;
    CheckUserIdReplyDAOBean checkUserIdReplyDAOBean;
    DeleteReplyHeartDAOBean deleteReplyHeartDAOBean;
    UpdateReplyHeartCountDAOBean updateReplyHeartCountDAOBean;
    SaveReplyDAOBean saveReplyDAOBean;

    @Autowired
    public DeleteReplyHeartBean(GetReplyHeartDAOBean getReplyHeartDAOBean, CheckReplyIdReplyDAOBean checkReplyIdReplyDAOBean, CheckUserIdReplyDAOBean checkUserIdReplyDAOBean, DeleteReplyHeartDAOBean deleteReplyHeartDAOBean, UpdateReplyHeartCountDAOBean updateReplyHeartCountDAOBean, SaveReplyDAOBean saveReplyDAOBean) {
        this.getReplyHeartDAOBean = getReplyHeartDAOBean;
        this.checkReplyIdReplyDAOBean = checkReplyIdReplyDAOBean;
        this.checkUserIdReplyDAOBean = checkUserIdReplyDAOBean;
        this.deleteReplyHeartDAOBean = deleteReplyHeartDAOBean;
        this.updateReplyHeartCountDAOBean = updateReplyHeartCountDAOBean;
        this.saveReplyDAOBean = saveReplyDAOBean;
    }

    // 대댓글 좋아요 삭제
    public Long exec(RequestReplyHeartDeleteDTO replyHeartDeleteDTO){

        // 대댓글 좋아요 아이디 찾기
        Long rHId = replyHeartDeleteDTO.getRHId();

        // 아이디로 삭제할 좋아요 찾기
        ReplyHeartDAO replyHeartDAO = getReplyHeartDAOBean.exec(rHId);

        // 대댓글 좋아요 해당하는 대댓글 확인
        if (!checkReplyIdReplyDAOBean.exec(replyHeartDAO, replyHeartDeleteDTO))
            return null;

        // 대댓글 좋아요 해당하는 유저 확인
        if (!checkUserIdReplyDAOBean.exec(replyHeartDAO, replyHeartDeleteDTO))
            return null;

        // 대댓글 삭제
        deleteReplyHeartDAOBean.exec(replyHeartDAO);

        // 대댓글 좋아요 갯수 감소
        ReplyDAO replyDAO = updateReplyHeartCountDAOBean.exec(rHId, replyHeartDAO);

        // 대댓글 저장
        saveReplyDAOBean.exec(replyDAO);

        // rHId 반환
        return rHId;
    }
}
