package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetPostsDAOBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public GetPostsDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 게시물 찾기
    public Page<PostDAO> exec(Pageable pageable){
        return postRepositoryJPA.findAll(pageable);
    }
}
