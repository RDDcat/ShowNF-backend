package com.shownf.reptile.controller;

import com.shownf.reptile.Model.DTO.RequestDiaryDTO;
import com.shownf.reptile.Model.DTO.RequestDiarySaveDTO;
import com.shownf.reptile.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class DiaryController {

    DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // 다이어리 조회
    @GetMapping("diary/{diaryId}")
    public RequestDiaryDTO getDiary(@PathVariable Long diaryId){
        return diaryService.getDiary(diaryId);
    }

    // 다이어리 저장
    @PostMapping("diary")
    public ResponseEntity<Map<String, Object>> saveDiary(@RequestBody RequestDiarySaveDTO requestDiarySaveDTO){
        Long diaryId = diaryService.saveDiary(requestDiarySaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (diaryId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (diaryId != null) ? "Save Success" : "Save Fail");
        requestMap.put("diaryId", diaryId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
