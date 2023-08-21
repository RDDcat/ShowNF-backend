package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.CommentDAO;
import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostCommentCountDAOBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public UpdatePostCommentCountDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 게시물 댓글 갯수 추가
    public PostDAO exec(CommentDAO commentDAO){

        // pId 가져오기
        Long pId = commentDAO.getPId();

        // pId 로 게시물 찾기
        PostDAO postDAO = postRepositoryJPA.findById(pId).get();

        // 게시물 댓글 수 1 증가
        postDAO.setCommentCount(postDAO.getCommentCount() + 1);

        // 게시물 반환
        return postDAO;
    }

    // 게시물 댓글 갯수 감소
    public PostDAO exec(Long cId, CommentDAO commentDAO){

        // pId 가져오기
        Long pId = commentDAO.getPId();

        // pId 로 게시물 찾기
        PostDAO postDAO = postRepositoryJPA.findById(pId).get();

        // 게시물 댓글 수 1 감소
        postDAO.setCommentCount(postDAO.getCommentCount() - 1);

        // 게시물 반환
        return postDAO;
    }
}
