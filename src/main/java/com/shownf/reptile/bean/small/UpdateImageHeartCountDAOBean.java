package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ImageDAO;
import com.shownf.reptile.entity.ImageHeartDAO;
import com.shownf.reptile.repository.ImageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateImageHeartCountDAOBean {

    ImageRepositoryJPA imageRepositoryJPA;

    @Autowired
    public UpdateImageHeartCountDAOBean(ImageRepositoryJPA imageRepositoryJPA) {
        this.imageRepositoryJPA = imageRepositoryJPA;
    }

    // 이미지 좋아요 갯수 추가
    public ImageDAO exec(ImageHeartDAO imageHeartDAO){

        // iId 가져오기
        Long iId = imageHeartDAO.getIId();

        // iId 로 이미지 찾기
        ImageDAO imageDAO = imageRepositoryJPA.findById(iId).get();

        // 이미지 좋아요 수 1 증가
        imageDAO.setHeartCount(imageDAO.getHeartCount() + 1);

        // 이미지 반환
        return imageDAO;
    }
}
