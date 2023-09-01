package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ReplyDAO;
import com.shownf.reptile.repository.ReplyRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetReplyDAOBean {

    ReplyRepositoryJPA replyRepositoryJPA;

    @Autowired
    public GetReplyDAOBean(ReplyRepositoryJPA replyRepositoryJPA) {
        this.replyRepositoryJPA = replyRepositoryJPA;
    }

    // 대댓글 찾기
    public ReplyDAO exec(Long replyId){
        return replyRepositoryJPA.findById(replyId).get();
    }
}
