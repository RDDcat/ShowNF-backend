package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ReplyDAO;
import com.shownf.reptile.entity.ReplyHeartDAO;
import com.shownf.reptile.repository.ReplyRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateReplyHeartCountDAOBean {

    ReplyRepositoryJPA replyRepositoryJPA;

    @Autowired
    public UpdateReplyHeartCountDAOBean(ReplyRepositoryJPA replyRepositoryJPA) {
        this.replyRepositoryJPA = replyRepositoryJPA;
    }

    // 대댓글 좋아요 갯수 추가
    public ReplyDAO exec(ReplyHeartDAO replyHeartDAO){

        // replyId 가져오기
        Long replyId = replyHeartDAO.getReplyId();

        // replyId 로 댓글 찾기
        ReplyDAO replyDAO = replyRepositoryJPA.findById(replyId).get();

        // 대댓글 좋아요 수 1 증가
        replyDAO.setHeartCount(replyDAO.getHeartCount() + 1);

        // 대댓글 반환
        return replyDAO;
    }

    // 대댓글 좋아요 갯수 감소
    public ReplyDAO exec(Long replyHeartId, ReplyHeartDAO replyHeartDAO){

        // replyId 가져오기
        Long replyId = replyHeartDAO.getReplyId();

        // replyId 로 댓글 찾기
        ReplyDAO replyDAO = replyRepositoryJPA.findById(replyId).get();

        // 대댓글 좋아요 수 1 감소
        replyDAO.setHeartCount(replyDAO.getHeartCount() - 1);

        // 대댓글 반환
        return replyDAO;
    }
}
