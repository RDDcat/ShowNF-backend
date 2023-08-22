package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.CommentHeartDAO;
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

    public void exec(CommentHeartDAO commentHeartDAO){
        commentHeartRepositoryJPA.save(commentHeartDAO);
    }
}
