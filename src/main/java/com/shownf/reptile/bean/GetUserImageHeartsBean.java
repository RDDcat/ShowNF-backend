package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.ResponseImagesDTO;
import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.Model.entity.ImageHeartDAO;
import com.shownf.reptile.bean.small.CreateImagesDTOBean;
import com.shownf.reptile.bean.small.GetImageHeartsDAOBean;
import com.shownf.reptile.bean.small.GetImageHeartsImageIdBean;
import com.shownf.reptile.bean.small.GetImagesDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserImageHeartsBean {

    GetImageHeartsDAOBean getImageHeartsDAOBean;
    GetImageHeartsImageIdBean getImageHeartsImageIdBean;
    GetImagesDAOBean getImagesDAOBean;
    CreateImagesDTOBean createImagesDTOBean;

    @Autowired
    public GetUserImageHeartsBean(GetImageHeartsDAOBean getImageHeartsDAOBean, GetImageHeartsImageIdBean getImageHeartsImageIdBean, GetImagesDAOBean getImagesDAOBean, CreateImagesDTOBean createImagesDTOBean) {
        this.getImageHeartsDAOBean = getImageHeartsDAOBean;
        this.getImageHeartsImageIdBean = getImageHeartsImageIdBean;
        this.getImagesDAOBean = getImagesDAOBean;
        this.createImagesDTOBean = createImagesDTOBean;
    }

    // 유저가 좋아요한 이미지 조회
    public List<ResponseImagesDTO> exec(String userId){

        // 유저 아이디를 통해 이미지 좋아요 객체 찾기
        List<ImageHeartDAO> imageHeartDAOs = getImageHeartsDAOBean.exec(userId);

        System.out.println("imageHeartDAOs.get(0).getUserId() = " + imageHeartDAOs.get(0).getUserId());
        
        // 좋아요 객체에서 이미지 아이디 찾기
        List<Long> imageIds = getImageHeartsImageIdBean.exec(imageHeartDAOs);

        // 이미지 아이디로 이미지 찾기
        List<ImageDAO> imageDAOs = getImagesDAOBean.exec(imageIds);

        // DAO 객체 DTO 로 반환
        return createImagesDTOBean.exec(imageDAOs);
    }
}
