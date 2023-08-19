package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostDAOBean {
    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public GetPostDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 게시물 객체 찾기
    public PostDAO exec(Long pId){
        return postRepositoryJPA.findById(pId).get();
    }
}
