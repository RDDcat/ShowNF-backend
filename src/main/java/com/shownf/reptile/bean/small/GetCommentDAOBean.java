package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.CommentDAO;
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

    public CommentDAO exec(Long cId){
        return commentRepositoryJPA.findById(cId).get();
    }
}
