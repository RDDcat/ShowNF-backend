package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestReplyHeartDeleteDTO;
import com.shownf.reptile.DTO.RequestReplyHeartSaveDTO;
import com.shownf.reptile.service.ReplyHeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class ReplyHeartController {

    ReplyHeartService replyHeartService;

    @Autowired
    public ReplyHeartController(ReplyHeartService replyHeartService) {
        this.replyHeartService = replyHeartService;
    }

    // 대댓글 좋아요 저장
    @PostMapping("replyHeart")
    public ResponseEntity<Map<String, Object>> saveReplyHeart(@RequestBody RequestReplyHeartSaveDTO requestReplyHeartSaveDTO){
        Long rHId = replyHeartService.saveReplyHeart(requestReplyHeartSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (rHId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (rHId != null) ? "Save Success" : "Save Fail");
        requestMap.put("rHId", rHId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 대댓글 좋아요 삭제
    @DeleteMapping("replyHeart")
    public ResponseEntity<Map<String, Object>> deleteReplyHeart(@RequestBody RequestReplyHeartDeleteDTO requestReplyHeartDeleteDTO){
        Long rHId = replyHeartService.deleteReplyHeart(requestReplyHeartDeleteDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (rHId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (rHId != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("rHId", rHId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
