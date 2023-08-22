package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.CommentDAO;
import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.entity.ReplyDAO;
import com.shownf.reptile.repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCommentReplyCountDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public UpdateCommentReplyCountDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    // 댓글 대댓글 갯수 추가
    public CommentDAO exec(ReplyDAO replyDAO){

        // cId 가져오기
        Long cId = replyDAO.getCId();

        // cId 로 댓글 찾기
        CommentDAO commentDAO = commentRepositoryJPA.findById(cId).get();

        // 댓글 대댓글 수 1 증가
        commentDAO.setReplyCount(commentDAO.getReplyCount() + 1);

        // 댓글 반환
        return commentDAO;
    }
}
