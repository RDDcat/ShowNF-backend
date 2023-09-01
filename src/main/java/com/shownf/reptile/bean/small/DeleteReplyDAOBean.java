package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ReplyDAO;
import com.shownf.reptile.repository.ReplyRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReplyDAOBean {

    ReplyRepositoryJPA replyRepositoryJPA;

    @Autowired
    public DeleteReplyDAOBean(ReplyRepositoryJPA replyRepositoryJPA) {
        this.replyRepositoryJPA = replyRepositoryJPA;
    }

    // 대댓글 삭제
    public void exec(ReplyDAO replyDAO){
        replyRepositoryJPA.delete(replyDAO);
    }
}
