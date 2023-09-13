package com.shownf.reptile.bean.small;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.Model.entity.PetDAO;
import com.shownf.reptile.repository.PetRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class SavePetDAOBean {

    PetRepositoryJPA petRepositoryJPA;

    @Autowired
    public SavePetDAOBean(PetRepositoryJPA petRepositoryJPA) {
        this.petRepositoryJPA = petRepositoryJPA;
    }

    // 마이펫 Repository 저장하기
    public void exec(PetDAO petDAO){
        petRepositoryJPA.save(petDAO);
    }

    // 마이펫 저장시 DAO 생성
    public void exec(Long petId, RequestPetSaveDTO requestPetSaveDTO){

        // 유저 아이디
        String userId = requestPetSaveDTO.getUserId();

        // 이미지 Url
        ObjectMapper objectMapper = new ObjectMapper();
        String imageUrl = "";
        try {
            imageUrl = objectMapper.writeValueAsString(requestPetSaveDTO.getImageUrl());
        }catch (IOException e){
            e.printStackTrace();
        }

        // 이름
        String name = requestPetSaveDTO.getName();

        // 첫번째 종
        String firstSpecies = requestPetSaveDTO.getFirstSpecies();

        // 두번째 종
        String secondSpecies = requestPetSaveDTO.getSecondSpecies();

        // 생일
        String birthday = requestPetSaveDTO.getBirthday();

        // 몸무게
        Double weight = requestPetSaveDTO.getWeight();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        exec(new PetDAO(petId, userId, imageUrl, name, firstSpecies, secondSpecies, birthday, weight, uploadTime));

    }
}
