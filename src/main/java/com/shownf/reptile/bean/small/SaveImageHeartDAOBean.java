package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageHeartDAO;
import com.shownf.reptile.repository.ImageHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveImageHeartDAOBean {

    ImageHeartRepositoryJPA imageHeartRepositoryJPA;

    @Autowired
    public SaveImageHeartDAOBean(ImageHeartRepositoryJPA imageHeartRepositoryJPA) {
        this.imageHeartRepositoryJPA = imageHeartRepositoryJPA;
    }

    // 이미지 좋아요 저장
    public void exec(ImageHeartDAO imageHeartDAO){
        imageHeartRepositoryJPA.save(imageHeartDAO);
    }
}
