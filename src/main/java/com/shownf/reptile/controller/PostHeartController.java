package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestPostHeartDTO;
import com.shownf.reptile.service.PostHeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class PostHeartController {

    PostHeartService postHeartService;

    @Autowired
    public PostHeartController(PostHeartService postHeartService) {
        this.postHeartService = postHeartService;
    }

    // 게시물 좋아요 추가
    @PostMapping("postHeart")
    public ResponseEntity<Map<String, Object>> savePost(@RequestBody RequestPostHeartDTO requestPostHeartDTO){
        Long hId = postHeartService.savePostHeart(requestPostHeartDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (hId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (hId != null) ? "Save Success" : "Save Fail");
        requestMap.put("hId", hId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
