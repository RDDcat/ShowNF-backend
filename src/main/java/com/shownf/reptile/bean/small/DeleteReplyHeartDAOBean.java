package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ReplyHeartDAO;
import com.shownf.reptile.repository.ReplyHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReplyHeartDAOBean {

    ReplyHeartRepositoryJPA replyHeartRepositoryJPA;

    @Autowired
    public DeleteReplyHeartDAOBean(ReplyHeartRepositoryJPA replyHeartRepositoryJPA) {
        this.replyHeartRepositoryJPA = replyHeartRepositoryJPA;
    }

    // 대댓글 좋아요 삭제
    public void exec(ReplyHeartDAO replyHeartDAO){
        replyHeartRepositoryJPA.delete(replyHeartDAO);
    }
}
