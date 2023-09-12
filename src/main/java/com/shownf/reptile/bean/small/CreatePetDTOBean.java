package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPetDTO;
import com.shownf.reptile.Model.entity.PetDAO;
import org.springframework.stereotype.Component;

@Component
public class CreatePetDTOBean {

    // 마이펫 조회 시 DTO 생성
    public RequestPetDTO exec(PetDAO petDAO){
        RequestPetDTO requestPetDTO = new RequestPetDTO();

        // DTO 객체에 마이펫 정보 넘기기
        requestPetDTO.setPetId(petDAO.getPetId());
        requestPetDTO.setUserId(petDAO.getUserId());
        requestPetDTO.setImageUrl(petDAO.getImageUrl());
        requestPetDTO.setName(petDAO.getName());
        requestPetDTO.setFirstSpecies(petDAO.getFirstSpecies());
        requestPetDTO.setSecondSpecies(petDAO.getSecondSpecies());
        requestPetDTO.setBirthday(petDAO.getBirthday());
        requestPetDTO.setWeight(petDAO.getWeight());
        requestPetDTO.setUploadTime(petDAO.getUploadTime());

        // DTO 반환
        return requestPetDTO;
    }
}
