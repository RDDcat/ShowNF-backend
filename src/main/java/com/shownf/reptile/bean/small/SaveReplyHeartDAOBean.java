package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ReplyHeartDAO;
import com.shownf.reptile.repository.ReplyHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveReplyHeartDAOBean {

    ReplyHeartRepositoryJPA replyHeartRepositoryJPA;

    @Autowired
    public SaveReplyHeartDAOBean(ReplyHeartRepositoryJPA replyHeartRepositoryJPA) {
        this.replyHeartRepositoryJPA = replyHeartRepositoryJPA;
    }

    // 대댓글 좋아요 저장
    public void exec(ReplyHeartDAO replyHeartDAO){
        replyHeartRepositoryJPA.save(replyHeartDAO);
    }
}
