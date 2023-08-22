package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.DTO.RequestReplySaveDTO;
import com.shownf.reptile.service.ReplyService;
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
public class ReplyController {

    ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
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
}
