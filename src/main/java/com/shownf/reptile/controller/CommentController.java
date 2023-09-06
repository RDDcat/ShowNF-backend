package com.shownf.reptile.controller;

import com.shownf.reptile.Model.DTO.RequestCommentDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.Model.DTO.RequestCommentsDTO;
import com.shownf.reptile.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 전체 조회
    @GetMapping("comment/post/{postId}")
    public List<RequestCommentsDTO> getComments(@PathVariable Long postId){
        return commentService.getComments(postId);
    }

    // 댓글 저장
    @PostMapping("comment")
    public ResponseEntity<Map<String, Object>> saveComment(@RequestBody RequestCommentSaveDTO requestCommentSaveDTO){
        Long commentId = commentService.saveComment(requestCommentSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (commentId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (commentId != null) ? "Save Success" : "Save Fail");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 댓글 삭제
    @DeleteMapping("comment")
    public ResponseEntity<Map<String, Object>> deleteComment(@RequestBody RequestCommentDeleteDTO requestCommentDeleteDTO){
        Long commentId = commentService.deleteComment(requestCommentDeleteDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (commentId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (commentId != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
