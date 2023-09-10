package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestPetDTO;
import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.bean.GetPetBean;
import com.shownf.reptile.bean.SavePetBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    GetPetBean getPetBean;
    SavePetBean savePetBean;

    @Autowired
    public PetService(GetPetBean getPetBean, SavePetBean savePetBean) {
        this.getPetBean = getPetBean;
        this.savePetBean = savePetBean;
    }

    // 마이펫 조회
    public RequestPetDTO getPet(Long petId){
        return getPetBean.exec(petId);
    }

    // 마이펫 저장
    public Long savePet(RequestPetSaveDTO requestPetSaveDTO){
        return savePetBean.exec(requestPetSaveDTO);
    }
}
