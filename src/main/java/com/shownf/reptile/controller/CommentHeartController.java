package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestCommentHeartDeleteDTO;
import com.shownf.reptile.DTO.RequestCommentHeartSaveDTO;
import com.shownf.reptile.service.CommentHeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CommentHeartController {

    CommentHeartService commentHeartService;

    @Autowired
    public CommentHeartController(CommentHeartService commentHeartService) {
        this.commentHeartService = commentHeartService;
    }

    // 댓글 좋아요 추가
    @PostMapping("commentHeart")
    public ResponseEntity<Map<String, Object>> saveCommentHeart(@RequestBody RequestCommentHeartSaveDTO requestCommentHeartSaveDTO){
        Long cHId = commentHeartService.saveCommentHeart(requestCommentHeartSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (cHId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (cHId != null) ? "Save Success" : "Save Fail");
        requestMap.put("cHId", cHId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 댓글 좋아요 삭제
    @DeleteMapping("commentHeart")
    public ResponseEntity<Map<String, Object>> deleteCommentHeart(@RequestBody RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){
        Long cHId = commentHeartService.deleteCommentHeart(requestCommentHeartDeleteDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (cHId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (cHId != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("cHId", cHId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
