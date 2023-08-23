package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestReplyDeleteDTO;
import com.shownf.reptile.DTO.RequestReplySaveDTO;
import com.shownf.reptile.DTO.RequestReplysDTO;
import com.shownf.reptile.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ReplyController {

    ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    // 대댓글 전체 조회
    @GetMapping("reply/{cId}")
    public List<RequestReplysDTO> getReplys(@PathVariable Long cId){
        System.out.println(replyService.getReplys(cId).get(0).getCId());
        return replyService.getReplys(cId);
    }

    // 대댓글 저장
    @PostMapping("reply")
    public ResponseEntity<Map<String, Object>> saveReply(@RequestBody RequestReplySaveDTO requestReplySaveDTO){
        Long rid = replyService.saveReply(requestReplySaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (rid != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (rid != null) ? "Save Success" : "Save Fail");
        requestMap.put("rid", rid);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }

    // 대댓글 삭제
    @DeleteMapping("reply")
    public ResponseEntity<Map<String, Object>> deleteComment(@RequestBody RequestReplyDeleteDTO requestReplyDeleteDTO){
        Long rId = replyService.deleteReply(requestReplyDeleteDTO);

        // HTTP 상태 반환
        HttpStatus httpStatus = (rId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (rId != null) ? "Delete Success" : "Delete Fail");
        requestMap.put("rId", rId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
