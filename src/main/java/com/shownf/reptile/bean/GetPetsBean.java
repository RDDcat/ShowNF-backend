package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestPetDTO;
import com.shownf.reptile.Model.entity.PetDAO;
import com.shownf.reptile.bean.small.CreatePetsDTOBean;
import com.shownf.reptile.bean.small.GetPetsDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetPetsBean {

    GetPetsDAOBean getPetsDAOBean;
    CreatePetsDTOBean createPetsDTOBean;

    @Autowired
    public GetPetsBean(GetPetsDAOBean getPetsDAOBean, CreatePetsDTOBean createPetsDTOBean) {
        this.getPetsDAOBean = getPetsDAOBean;
        this.createPetsDTOBean = createPetsDTOBean;
    }

    // 마이펫 Page 형태로 전체 조회
    public Page<RequestPetDTO> exec(String userId, Pageable pageable){

        // 유저 아이디로 마이펫 전체 찾기
        Page<PetDAO> petDAOs = getPetsDAOBean.exec(userId, pageable);

        // DAO 객체 DTO 반환
        return createPetsDTOBean.exec(pageable, petDAOs);
    }
}
