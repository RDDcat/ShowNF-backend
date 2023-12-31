package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.Model.entity.ImageHeartDAO;
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

        // imageId 가져오기
        Long imageId = imageHeartDAO.getImageId();

        // imageId 로 이미지 찾기
        ImageDAO imageDAO = imageRepositoryJPA.findById(imageId).get();

        // 이미지 좋아요 수 1 증가
        imageDAO.setHeartCount(imageDAO.getHeartCount() + 1);

        // 이미지 반환
        return imageDAO;
    }

    // 이미지 좋아요 갯수 감소
    public ImageDAO exec(Long imageHeartId, ImageHeartDAO imageHeartDAO){

        // imageId 가져오기
        Long imageId = imageHeartDAO.getImageId();

        // imageId 로 이미지 찾기
        ImageDAO imageDAO = imageRepositoryJPA.findById(imageId).get();

        // 이미지 좋아요 수 1 증가
        imageDAO.setHeartCount(imageDAO.getHeartCount() - 1);

        // 이미지 반환
        return imageDAO;
    }
}
