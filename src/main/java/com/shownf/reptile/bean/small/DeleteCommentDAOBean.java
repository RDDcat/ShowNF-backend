package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public DeleteCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 댓글 삭제
    public void exec(CommentDAO commentDAO){
        commentRepositoryJPA.delete(commentDAO);
    }
}
