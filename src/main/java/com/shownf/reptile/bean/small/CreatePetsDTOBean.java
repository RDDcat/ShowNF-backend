package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPetDTO;
import com.shownf.reptile.Model.entity.PetDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePetsDTOBean {

    // 유저 아이디로 마이펫 조회시 DTO 생성
    public Page<RequestPetDTO> exec(Pageable pageable, Page<PetDAO> petDAOs){

        List<RequestPetDTO> requestPetDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (PetDAO petDAO: petDAOs) {
            RequestPetDTO requestPetDTO = new RequestPetDTO();

            requestPetDTO.setPetId(petDAO.getPetId());
            requestPetDTO.setUserId(petDAO.getUserId());
            requestPetDTO.setImageUrl(petDAO.getImageUrl());
            requestPetDTO.setName(petDAO.getName());
            requestPetDTO.setFirstSpecies(petDAO.getFirstSpecies());
            requestPetDTO.setSecondSpecies(petDAO.getSecondSpecies());
            requestPetDTO.setBirthday(petDAO.getBirthday());
            requestPetDTO.setWeight(petDAO.getWeight());

            requestPetDTOs.add(requestPetDTO);
        }

        // List 구조를 Page 구조로 변경 후 반환
        return new PageImpl<>(requestPetDTOs, pageable, petDAOs.getTotalElements());
    }
}
