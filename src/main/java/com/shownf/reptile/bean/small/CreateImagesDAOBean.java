package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.Model.entity.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CreateImagesDAOBean {
    CreateImageDAOBean createImageDAOBean;
    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateImagesDAOBean( CreateImageDAOBean createImageDAOBean, CreateUniqueIdBean createUniqueIdBean) {
        this.createImageDAOBean = createImageDAOBean;
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 이미지 생성시 DAO 저장
    public List<ImageDAO> exec(List<MultipartFile> files, List<String> imageUrls) throws IOException {
        List<ImageDAO> imageDAOs = new ArrayList<>();

        int size = files.size();
        for (int i = 0; i < size; i++) {
            ImageDAO imageDAO = createImageDAOBean.exec(files.get(i), imageUrls.get(i));
            imageDAOs.add(imageDAO);
        }

        return imageDAOs;
    }

    // 이미지 생성시 DAO 저장
    // 개선가능 : 내부 로직을 CreateIamgeDAOBean으로 넣는 방식 exec 추가
    public List<ImageDAO> exec(RequestPostSaveDTO requestPostSaveDTO) {

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
        return imageDAOs;
    }
}
