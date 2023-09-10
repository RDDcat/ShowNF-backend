package com.shownf.reptile.controller;

import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PetController {

    PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // 게시물 저장
    @PostMapping("pet")
    public ResponseEntity<Map<String, Object>> savePet(@RequestBody RequestPetSaveDTO requestPetSaveDTO){
        Long petId = petService.savePet(requestPetSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (petId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (petId != null) ? "Save Success" : "Save Fail");
        requestMap.put("petId", petId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
