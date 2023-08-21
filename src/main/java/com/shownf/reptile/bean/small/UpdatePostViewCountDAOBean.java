package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostDAO;
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

        // pId 가져오기
        Long pId = postDAO.getPId();

        // pId 로 게시물 찾기
        PostDAO postDAO1 = postRepositoryJPA.findById(pId).get();

        // 게시물 조회수 1 증가
        postDAO1.setViewCount(postDAO.getViewCount() + 1);

        // 게시물 반환
        return postDAO1;
    }
}
