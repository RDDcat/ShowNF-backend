package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.CommentHeartDAO;
import com.shownf.reptile.repository.CommentHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentHeartDAOBean {

    CommentHeartRepositoryJPA commentHeartRepositoryJPA;

    @Autowired
    public DeleteCommentHeartDAOBean(CommentHeartRepositoryJPA commentHeartRepositoryJPA) {
        this.commentHeartRepositoryJPA = commentHeartRepositoryJPA;
    }

    // 댓글 좋아요 삭제
    public void exec(CommentHeartDAO commentHeartDAO){
        commentHeartRepositoryJPA.delete(commentHeartDAO);
    }
}
