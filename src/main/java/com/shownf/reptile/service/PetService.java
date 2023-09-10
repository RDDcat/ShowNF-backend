package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.bean.SavePetBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    SavePetBean savePetBean;

    @Autowired
    public PetService(SavePetBean savePetBean) {
        this.savePetBean = savePetBean;
    }

    // 마이펫 저장
    public Long savePet(RequestPetSaveDTO requestPetSaveDTO){
        return savePetBean.exec(requestPetSaveDTO);
    }
}
