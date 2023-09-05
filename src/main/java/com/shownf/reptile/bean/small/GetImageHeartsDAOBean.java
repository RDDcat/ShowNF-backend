package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ImageHeartDAO;
import com.shownf.reptile.repository.ImageHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetImageHeartsDAOBean {

    ImageHeartRepositoryJPA imageHeartRepositoryJPA;

    @Autowired
    public GetImageHeartsDAOBean(ImageHeartRepositoryJPA imageHeartRepositoryJPA) {
        this.imageHeartRepositoryJPA = imageHeartRepositoryJPA;
    }

    // 유저 아이디로 좋아요 객체 찾기
    public List<ImageHeartDAO> exec(String userId){
        return imageHeartRepositoryJPA.findByUserId(userId);
    }
}
