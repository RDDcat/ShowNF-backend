package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostDAOBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public SavePostDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 게시물 저장하기
    public void exec(PostDAO postDAO){
        postRepositoryJPA.save(postDAO);
    }
}
