package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.PostHeartDAO;
import com.shownf.reptile.repository.PostHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPostHeartsDAOBean {

    PostHeartRepositoryJPA postHeartRepositoryJPA;

    @Autowired
    public GetPostHeartsDAOBean(PostHeartRepositoryJPA postHeartRepositoryJPA) {
        this.postHeartRepositoryJPA = postHeartRepositoryJPA;
    }

    // 좋아요 아이디로 좋아요 객체 찾기
    public List<PostHeartDAO> exec(String userId){
        return postHeartRepositoryJPA.findByUserId(userId);
    }
}
