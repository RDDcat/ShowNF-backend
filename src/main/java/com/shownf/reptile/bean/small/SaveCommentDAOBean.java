package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public SaveCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 댓글 저장
    public void exec(CommentDAO commentDAO){
        commentRepositoryJPA.save(commentDAO);
    }
}
