package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.repository.ImageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetImagesDAOBean {

    ImageRepositoryJPA imageRepositoryJPA;

    @Autowired
    public GetImagesDAOBean(ImageRepositoryJPA imageRepositoryJPA) {
        this.imageRepositoryJPA = imageRepositoryJPA;
    }

    // 이미지 전체 찾기
    public Page<ImageDAO> exec(Pageable pageable){
        return imageRepositoryJPA.findAll(pageable);
    }
}
