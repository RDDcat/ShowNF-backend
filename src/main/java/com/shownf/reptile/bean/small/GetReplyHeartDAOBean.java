package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ReplyHeartDAO;
import com.shownf.reptile.repository.ReplyHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetReplyHeartDAOBean {

    ReplyHeartRepositoryJPA replyHeartRepositoryJPA;

    @Autowired
    public GetReplyHeartDAOBean(ReplyHeartRepositoryJPA replyHeartRepositoryJPA) {
        this.replyHeartRepositoryJPA = replyHeartRepositoryJPA;
    }

    // 대댓글 좋아요 객체 찾기
    public ReplyHeartDAO exec(Long rHId){
        return replyHeartRepositoryJPA.findById(rHId).get();
    }
}
