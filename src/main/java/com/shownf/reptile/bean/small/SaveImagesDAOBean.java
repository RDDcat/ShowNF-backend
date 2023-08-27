package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageDAO;
import com.shownf.reptile.repository.ImageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveImagesDAOBean {

    ImageRepositoryJPA imageRepositoryJPA;

    @Autowired
    public SaveImagesDAOBean(ImageRepositoryJPA imageRepositoryJPA) {
        this.imageRepositoryJPA = imageRepositoryJPA;
    }

    // 이미지 저장
    public void exec(List<ImageDAO> imageDAOs){
        for (ImageDAO imageDAO : imageDAOs){
                imageRepositoryJPA.save(imageDAO);
        }
    }
}
