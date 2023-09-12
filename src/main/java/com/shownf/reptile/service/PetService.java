package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestPetDTO;
import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.bean.GetPetBean;
import com.shownf.reptile.bean.GetPetsBean;
import com.shownf.reptile.bean.SavePetBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    GetPetBean getPetBean;
    GetPetsBean getPetsBean;
    SavePetBean savePetBean;

    @Autowired
    public PetService(GetPetBean getPetBean, GetPetsBean getPetsBean, SavePetBean savePetBean) {
        this.getPetBean = getPetBean;
        this.getPetsBean = getPetsBean;
        this.savePetBean = savePetBean;
    }

    // 마이펫 조회
    public RequestPetDTO getPet(Long petId){
        return getPetBean.exec(petId);
    }

    // 마이펫 전체 조회
    public Page<RequestPetDTO> getPets(String userId, Pageable pageable){
        return getPetsBean.exec(userId, pageable);
    }

    // 마이펫 저장
    public Long savePet(RequestPetSaveDTO requestPetSaveDTO){
        return savePetBean.exec(requestPetSaveDTO);
    }
}
