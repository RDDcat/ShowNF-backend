package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostHeartDAO;
import com.shownf.reptile.repository.PostHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePostHeartDAOBean {

    PostHeartRepositoryJPA postHeartRepositoryJPA;

    @Autowired
    public DeletePostHeartDAOBean(PostHeartRepositoryJPA postHeartRepositoryJPA) {
        this.postHeartRepositoryJPA = postHeartRepositoryJPA;
    }

    // 좋아요 삭제
    public void exec(PostHeartDAO postHeartDAO){
        postHeartRepositoryJPA.delete(postHeartDAO);
    }
}
