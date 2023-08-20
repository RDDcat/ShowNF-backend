package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.service.CommentService;
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
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 저장
    @PostMapping("comment")
    public ResponseEntity<Map<String, Object>> savePost(@RequestBody RequestCommentSaveDTO requestCommentSaveDTO){
        Long cId = commentService.saveComment(requestCommentSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (cId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (cId != null) ? "Save Success" : "Save Fail");
        requestMap.put("cId", cId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
