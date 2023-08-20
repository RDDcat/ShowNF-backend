package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물 조회
    @GetMapping("post/{pId}/user/{uId}")
    public RequestPostDTO getPost(@PathVariable long pId, @PathVariable String uId){
        return postService.getPostDAO(pId, uId);
    }

    // 게시물 저장
    @PostMapping("post")
    public ResponseEntity<Map<String, Object>> savePost(@RequestBody RequestPostSaveDTO requestPostSaveDTO){
        Long pId = postService.savePostDAO(requestPostSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (pId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (pId != null) ? "Save Success" : "Save Fail");
        requestMap.put("pId", pId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
