package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.repository.ImageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SaveImagesDAOBean {

    ImageRepositoryJPA imageRepositoryJPA;
    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public SaveImagesDAOBean(ImageRepositoryJPA imageRepositoryJPA, CreateUniqueIdBean createUniqueIdBean) {
        this.imageRepositoryJPA = imageRepositoryJPA;
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 이미지 저장
    public void exec(List<ImageDAO> imageDAOs){
        for (ImageDAO imageDAO : imageDAOs){
                imageRepositoryJPA.save(imageDAO);
        }
    }

    // 게시물 저장시 이미지 저장
    public void exec(RequestPostSaveDTO requestPostSaveDTO) {

        List<ImageDAO> imageDAOs = new ArrayList<>();

        // 입력받은 postContent 갯수
        List<Map<String, String>> list = requestPostSaveDTO.getContent();
        int count = list.size();

        for (int i = 0; i < count; i++) {

            // imageId 생성
            Long imageId = createUniqueIdBean.exec();

            // 이미지 이름
            String imageName = list.get(i).get("imageUrl").substring(list.get(i).get("imageUrl").lastIndexOf("8080/") + 5);

            // 이미지 Url
            String imageUrl = list.get(i).get("imageUrl");

            // 업로드 시간
            LocalDateTime uploadTime = LocalDateTime.now();

            // 이미지 좋아요 갯수
            Integer heartCount = 0;

            // 이미지 DAO 저장
            imageDAOs.add(new ImageDAO(imageId, imageName, imageUrl, uploadTime, heartCount));

        }
        exec(imageDAOs);
    }

    // 마이펫 저장시 이미지 저장
    public void exec(RequestPetSaveDTO requestPetSaveDTO) {

        List<ImageDAO> imageDAOs = new ArrayList<>();

        // 입력받은 postContent 갯수
        List<Map<String, String>> list = requestPetSaveDTO.getImageUrl();
        int count = list.size();

        for (int i = 0; i < count; i++) {

            // imageId 생성
            Long imageId = createUniqueIdBean.exec();

            // 이미지 이름
            String imageName = list.get(i).get("imageUrl").substring(list.get(i).get("imageUrl").lastIndexOf("8080/") + 5);

            // 이미지 Url
            String imageUrl = list.get(i).get("imageUrl");

            // 업로드 시간
            LocalDateTime uploadTime = LocalDateTime.now();

            // 이미지 좋아요 갯수
            Integer heartCount = 0;

            // 이미지 DAO 저장
            imageDAOs.add(new ImageDAO(imageId, imageName, imageUrl, uploadTime, heartCount));

        }
        exec(imageDAOs);
    }
}
