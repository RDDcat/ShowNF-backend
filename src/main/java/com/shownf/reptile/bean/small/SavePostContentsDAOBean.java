package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.PostContentDAO;
import com.shownf.reptile.repository.PostContentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavePostContentsDAOBean {

    PostContentRepositoryJPA postContentRepositoryJPA;

    @Autowired
    public SavePostContentsDAOBean(PostContentRepositoryJPA postContentRepositoryJPA) {
        this.postContentRepositoryJPA = postContentRepositoryJPA;
    }

    // 게시물 내용 저장
    public void exec(List<PostContentDAO> postContentDAOs){
        for (PostContentDAO postContentDAO : postContentDAOs)
            postContentRepositoryJPA.save(postContentDAO);
    }
}
