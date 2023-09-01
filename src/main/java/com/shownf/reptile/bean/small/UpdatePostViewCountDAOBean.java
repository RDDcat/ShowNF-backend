package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.PostDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostViewCountDAOBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public UpdatePostViewCountDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 게시물 찾기에 대한 조회수 1 증가
    public PostDAO exec(PostDAO postDAO){

        // postId 가져오기
        Long postId = postDAO.getPostId();

        // postId 로 게시물 찾기
        PostDAO postDAO1 = postRepositoryJPA.findById(postId).get();

        // 게시물 조회수 1 증가
        postDAO1.setViewCount(postDAO.getViewCount() + 1);

        // 게시물 반환
        return postDAO1;
    }
}
