package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.DTO.RequestPostHeartSaveDTO;
import com.shownf.reptile.service.PostHeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PostHeartController {

    PostHeartService postHeartService;

    @Autowired
    public PostHeartController(PostHeartService postHeartService) {
        this.postHeartService = postHeartService;
    }

    // 게시물 좋아요 추가
    @PostMapping("postHeart")
    public ResponseEntity<Map<String, Object>> savePostHeart(@RequestBody RequestPostHeartSaveDTO requestPostHeartDTO){
        Long postHeartId = postHeartService.savePostHeart(requestPostHeartDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (postHeartId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (postHeartId != null) ? "Save Success" : "Save Fail");
        requestMap.put("postHeartId", postHeartId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 게시물 좋아요 삭제
    @DeleteMapping("postHeart")
    public ResponseEntity<Map<String, Object>> deletePostHeart(@RequestBody RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){
        Long postHeartId = postHeartService.deletePostHeart(requestPostHeartDeleteDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (postHeartId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (postHeartId != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("postHeartId", postHeartId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
