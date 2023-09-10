package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestPetDTO;
import com.shownf.reptile.Model.entity.PetDAO;
import com.shownf.reptile.bean.small.CreatePetDTOBean;
import com.shownf.reptile.bean.small.GetPetDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPetBean {

    GetPetDAOBean getPetDAOBean;
    CreatePetDTOBean createPetDTOBean;

    @Autowired
    public GetPetBean(GetPetDAOBean getPetDAOBean, CreatePetDTOBean createPetDTOBean) {
        this.getPetDAOBean = getPetDAOBean;
        this.createPetDTOBean = createPetDTOBean;
    }

    // 마이펫 조회
    public RequestPetDTO exec(Long petId){

        // petId 로 마이펫 찾기
        PetDAO petDAO = getPetDAOBean.exec(petId);

        // 마이펫 객체 DTO 변환 후 반환
        return createPetDTOBean.exec(petDAO);
    }
}
