package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestImageDTO;
import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.bean.small.CreateImagesDTOBean;
import com.shownf.reptile.bean.small.GetImagesDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetImagesBean {

    GetImagesDAOBean getImagesDAOBean;
    CreateImagesDTOBean createImagesDTOBean;

    @Autowired
    public GetImagesBean(GetImagesDAOBean getImagesDAOBean, CreateImagesDTOBean createImagesDTOBean) {
        this.getImagesDAOBean = getImagesDAOBean;
        this.createImagesDTOBean = createImagesDTOBean;
    }

    // 이미지 Page 형태로 전체 조회
    public Page<RequestImageDTO> exec(Pageable pageable){

        // 이미지 전체 찾기
        Page<ImageDAO> imageDAOs = getImagesDAOBean.exec(pageable);

        // DAO 객체 DTO 반환
        return createImagesDTOBean.exec(pageable, imageDAOs);
    }
}
