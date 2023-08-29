package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageHeartDAO;
import com.shownf.reptile.repository.ImageHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetImageHeartDAOBean {

    ImageHeartRepositoryJPA imageHeartRepositoryJPA;

    @Autowired
    public GetImageHeartDAOBean(ImageHeartRepositoryJPA imageHeartRepositoryJPA) {
        this.imageHeartRepositoryJPA = imageHeartRepositoryJPA;
    }

    // 이미지 좋아요 아이디로 삭제할 좋아요 찾기
    public ImageHeartDAO exec(Long imageHeartId){
        return imageHeartRepositoryJPA.findById(imageHeartId).get();
    }
}
