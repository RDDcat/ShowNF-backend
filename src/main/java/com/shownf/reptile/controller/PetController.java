package com.shownf.reptile.controller;

import com.shownf.reptile.Model.DTO.RequestPetDTO;
import com.shownf.reptile.Model.DTO.RequestPetSaveDTO;
import com.shownf.reptile.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 마이펫 조회
    @GetMapping("pet/{petId}")
    public RequestPetDTO getPet(@PathVariable Long petId){
        return petService.getPet(petId);
    }

    // 마이펫 전체 조회
    @GetMapping("pet/user/{userId}")
    public Page<RequestPetDTO> getHotPosts(@PathVariable String userId, @PageableDefault(size=12, sort="uploadTime", direction = Sort.Direction.ASC) Pageable pageable){
        return petService.getPets(userId, pageable);
    }

    // 마이펫 저장
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
