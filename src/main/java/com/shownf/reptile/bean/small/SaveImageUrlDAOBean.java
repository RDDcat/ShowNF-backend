package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageDAO;
import com.shownf.reptile.entity.ImageUrlDAO;
import com.shownf.reptile.repository.ImageUrlRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveImageUrlDAOBean {

    ImageUrlRepositoryJPA imageUrlRepositoryJPA;

    @Autowired
    public SaveImageUrlDAOBean(ImageUrlRepositoryJPA imageUrlRepositoryJPA) {
        this.imageUrlRepositoryJPA = imageUrlRepositoryJPA;
    }

    // 이미지 Url 저장
    public void exec(List<ImageUrlDAO> imageUrlDAOs){
        for (ImageUrlDAO imageUrlDAO : imageUrlDAOs){
            imageUrlRepositoryJPA.save(imageUrlDAO);
        }
    }
}
