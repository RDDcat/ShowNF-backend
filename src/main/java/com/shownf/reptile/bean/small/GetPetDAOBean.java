package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.PetDAO;
import com.shownf.reptile.repository.PetRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPetDAOBean {

    PetRepositoryJPA petRepositoryJPA;

    @Autowired
    public GetPetDAOBean(PetRepositoryJPA petRepositoryJPA) {
        this.petRepositoryJPA = petRepositoryJPA;
    }

    // 마이펫 찾기
    public PetDAO exec(Long petId){
        return petRepositoryJPA.findById(petId).get();
    }
}
