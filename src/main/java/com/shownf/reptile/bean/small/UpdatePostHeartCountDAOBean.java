package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.entity.PostHeartDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostHeartCountDAOBean {

    PostRepositoryJPA postRepositoryJPA;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public UpdatePostHeartCountDAOBean(PostRepositoryJPA postRepositoryJPA, SavePostDAOBean savePostDAOBean) {
        this.postRepositoryJPA = postRepositoryJPA;
        this.savePostDAOBean = savePostDAOBean;
    }

    // 게시물 좋아요 갯수 추가
    public PostDAO exec(PostHeartDAO postHeartDAO){

        // postId 가져오기
        Long postId = postHeartDAO.getPostId();

        // postId 로 게시물 찾기
        PostDAO postDAO = postRepositoryJPA.findById(postId).get();

        // 게시물 좋아요 수 1 증가
        postDAO.setHeartCount(postDAO.getHeartCount() + 1);

        // 게시물 반환
        return postDAO;
    }

    // 게시물 좋아요 갯수 감소
    public PostDAO exec(Long postHeartId, PostHeartDAO postHeartDAO){

        // postId 가져오기
        Long postId = postHeartDAO.getPostId();

        // postId 로 게시물 찾기
        PostDAO postDAO = postRepositoryJPA.findById(postId).get();

        // 게시물 좋아요 수 1 감소
        postDAO.setHeartCount(postDAO.getHeartCount() - 1);

        // 게시물 반환
        return postDAO;
    }
}
