package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageHeartDAO;
import com.shownf.reptile.repository.ImageHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteImageHeartDAOBean {

    ImageHeartRepositoryJPA imageHeartRepositoryJPA;

    @Autowired
    public DeleteImageHeartDAOBean(ImageHeartRepositoryJPA imageHeartRepositoryJPA) {
        this.imageHeartRepositoryJPA = imageHeartRepositoryJPA;
    }

    // 이미지 좋아요 삭제
    public void exec(ImageHeartDAO imageHeartDAO){
        imageHeartRepositoryJPA.delete(imageHeartDAO);
    }
}
