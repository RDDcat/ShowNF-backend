package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.bean.small.CreateUniqueIdBean;
import com.shownf.reptile.bean.small.SavePetDAOBean;
import org.springframework.stereotype.Component;

@Component
public class SavePetBean {

    CreateUniqueIdBean createUniqueIdBean;
    SavePetDAOBean savePetDAOBean;

    public Long exec(RequestPetSaveDTO requestPetSaveDTO){

        // petId 생성
        Long petId = createUniqueIdBean.exec();

        // 마이펫 저장
        savePetDAOBean.exec(petId, requestPetSaveDTO);

        // 마이펫 petId 반환
        return petId;
    }
}
