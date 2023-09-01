package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public GetCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 아디로 삭제할 댓글 찾기
    public CommentDAO exec(Long commentId){
        return commentRepositoryJPA.findById(commentId).get();
    }
}
