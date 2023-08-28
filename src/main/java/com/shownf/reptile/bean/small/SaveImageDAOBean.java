package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageDAO;
import com.shownf.reptile.repository.ImageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveImageDAOBean {

    ImageRepositoryJPA imageRepositoryJPA;

    @Autowired
    public SaveImageDAOBean(ImageRepositoryJPA imageRepositoryJPA) {
        this.imageRepositoryJPA = imageRepositoryJPA;
    }

    // 이미지 저장
    public void exec(ImageDAO imageDAO){
        imageRepositoryJPA.save(imageDAO);
    }
}
