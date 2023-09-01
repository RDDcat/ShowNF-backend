package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.Model.entity.CommentHeartDAO;
import com.shownf.reptile.repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCommentHeartCountDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public UpdateCommentHeartCountDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 댓글 좋아요 갯수 추가
    public CommentDAO exec(CommentHeartDAO commentHeartDAO){

        // commentId 가져오기
        Long commentId = commentHeartDAO.getCommentId();

        // commentId 로 게시물 찾기
        CommentDAO commentDAO = commentRepositoryJPA.findById(commentId).get();

        // 댓글 좋아요 수 1 증가
        commentDAO.setHeartCount(commentDAO.getHeartCount() + 1);

        // 댓글 반환
        return commentDAO;
    }

    // 댓글 좋아요 갯수 감소
    public CommentDAO exec(Long commentHeartId, CommentHeartDAO commentHeartDAO){

        // commentId 가져오기
        Long commentId = commentHeartDAO.getCommentId();

        // cId 로 게시물 찾기
        CommentDAO commentDAO = commentRepositoryJPA.findById(commentId).get();

        // 댓글 좋아요 수 1 증가
        commentDAO.setHeartCount(commentDAO.getHeartCount() - 1);

        // 댓글 반환
        return commentDAO;
    }
}
