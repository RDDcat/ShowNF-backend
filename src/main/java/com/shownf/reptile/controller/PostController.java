package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.service.PostService;
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
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물 조회
    @GetMapping("post/{postId}")
    public RequestPostDTO getPost(@PathVariable Long postId){
        return postService.getPostDAO(postId);
    }

    // 핫 게시물 조회
    @GetMapping("post")
    public Page<RequestPostDTO> getHotPosts(@PageableDefault(size=5, sort="heartCount", direction = Sort.Direction.DESC) Pageable pageable){
        return postService.getHotPosts(pageable);
    }

    // 게시물 저장
    @PostMapping("post")
    public ResponseEntity<Map<String, Object>> savePost(@RequestBody RequestPostSaveDTO requestPostSaveDTO){
        Long postId = postService.savePostDAO(requestPostSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (postId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (postId != null) ? "Save Success" : "Save Fail");
        requestMap.put("postId", postId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
