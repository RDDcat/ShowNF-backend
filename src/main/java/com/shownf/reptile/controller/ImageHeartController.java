package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestImageHeartDeleteDTO;
import com.shownf.reptile.DTO.RequestImageHeartSaveDTO;
import com.shownf.reptile.service.ImageHeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ImageHeartController {

    ImageHeartService imageHeartService;

    @Autowired
    public ImageHeartController(ImageHeartService imageHeartService) {
        this.imageHeartService = imageHeartService;
    }

    // 이미지 좋아요 저장
    @PostMapping("imageHeart")
    public ResponseEntity<Map<String, Object>> saveImageHeart(@RequestBody RequestImageHeartSaveDTO requestImageHeartSaveDTO){
        Long iHId = imageHeartService.saveImageHeart(requestImageHeartSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (iHId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (iHId != null) ? "Save Success" : "Save Fail");
        requestMap.put("iHId", iHId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 이미지 좋아요 삭제
    @DeleteMapping("imageHeart")
    public ResponseEntity<Map<String, Object>> deleteImageHeart(@RequestBody RequestImageHeartDeleteDTO requestImageHeartDeleteDTO){
        Long iHId = imageHeartService.deleteImageHeart(requestImageHeartDeleteDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (iHId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (iHId != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("iHId", iHId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
