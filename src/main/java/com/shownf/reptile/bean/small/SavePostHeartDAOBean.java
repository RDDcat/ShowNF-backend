package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostHeartDAO;
import com.shownf.reptile.repository.PostHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostHeartDAOBean {

    PostHeartRepositoryJPA postHeartRepositoryJPA;

    @Autowired
    public SavePostHeartDAOBean(PostHeartRepositoryJPA postHeartRepositoryJPA) {
        this.postHeartRepositoryJPA = postHeartRepositoryJPA;
    }

    // 좋아요 저장하기
    public void exec(PostHeartDAO postHeartDAO){
        postHeartRepositoryJPA.save(postHeartDAO);
    }
}
