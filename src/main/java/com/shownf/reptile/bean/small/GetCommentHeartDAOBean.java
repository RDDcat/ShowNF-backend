package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.CommentHeartDAO;
import com.shownf.reptile.repository.CommentHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCommentHeartDAOBean {

    CommentHeartRepositoryJPA commentHeartRepositoryJPA;

    @Autowired
    public GetCommentHeartDAOBean(CommentHeartRepositoryJPA commentHeartRepositoryJPA) {
        this.commentHeartRepositoryJPA = commentHeartRepositoryJPA;
    }

    // 댓글 좋아요 아이디로 삭제할 댓글 찾기
    public CommentHeartDAO exec(Long cHId){
        return commentHeartRepositoryJPA.findById(cHId).get();
    }
}
