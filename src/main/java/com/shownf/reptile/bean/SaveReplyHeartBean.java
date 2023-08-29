package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestReplyHeartSaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.ReplyDAO;
import com.shownf.reptile.entity.ReplyHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveReplyHeartBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateReplyHeartDAOBean createReplyHeartDAOBean;
    SaveReplyHeartDAOBean saveReplyHeartDAOBean;
    UpdateReplyHeartCountDAOBean updateReplyHeartCountDAOBean;
    SaveReplyDAOBean saveReplyDAOBean;

    @Autowired
    public SaveReplyHeartBean(CreateUniqueIdBean createUniqueIdBean, CreateReplyHeartDAOBean createReplyHeartDAOBean, SaveReplyHeartDAOBean saveReplyHeartDAOBean, UpdateReplyHeartCountDAOBean updateReplyHeartCountDAOBean, SaveReplyDAOBean saveReplyDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createReplyHeartDAOBean = createReplyHeartDAOBean;
        this.saveReplyHeartDAOBean = saveReplyHeartDAOBean;
        this.updateReplyHeartCountDAOBean = updateReplyHeartCountDAOBean;
        this.saveReplyDAOBean = saveReplyDAOBean;
    }

    // 대댓글 좋아요 저장
    public Long exec(RequestReplyHeartSaveDTO requestReplyHeartSaveDTO){

        // replyHeartId 생성
        Long replyHeartId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        ReplyHeartDAO replyHeartDAO = createReplyHeartDAOBean.exec(replyHeartId, requestReplyHeartSaveDTO);

        // 대댓글 좋아요 저장
        saveReplyHeartDAOBean.exec(replyHeartDAO);

        // 대댓글 좋아요 갯수 추가
        ReplyDAO replyDAO = updateReplyHeartCountDAOBean.exec(replyHeartDAO);

        // 대댓글 저장
        saveReplyDAOBean.exec(replyDAO);

        // replyHeartId 반환
        return replyHeartId;
    }
}
