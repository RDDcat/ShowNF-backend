package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.CommentHeartDAO;
import com.shownf.reptile.repository.CommentHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentHeartDAOBean {
    CommentHeartRepositoryJPA commentHeartRepositoryJPA;

    @Autowired
    public SaveCommentHeartDAOBean(CommentHeartRepositoryJPA commentHeartRepositoryJPA) {
        this.commentHeartRepositoryJPA = commentHeartRepositoryJPA;
    }

    // 댓글 좋아요 저장
    public void exec(CommentHeartDAO commentHeartDAO){
        commentHeartRepositoryJPA.save(commentHeartDAO);
    }
}
