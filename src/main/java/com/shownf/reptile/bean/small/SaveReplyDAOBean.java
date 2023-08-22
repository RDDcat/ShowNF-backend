package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ReplyDAO;
import com.shownf.reptile.repository.ReplyRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveReplyDAOBean {

    ReplyRepositoryJPA replyRepositoryJPA;

    @Autowired
    public SaveReplyDAOBean(ReplyRepositoryJPA replyRepositoryJPA) {
        this.replyRepositoryJPA = replyRepositoryJPA;
    }

    // 대댓글 저장
    public void exec(ReplyDAO replyDAO){
        replyRepositoryJPA.save(replyDAO);
    }
}
