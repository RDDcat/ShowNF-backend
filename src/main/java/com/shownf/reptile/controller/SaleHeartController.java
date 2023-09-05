package com.shownf.reptile.controller;

import com.shownf.reptile.Model.DTO.RequestSaleHeartSaveDTO;
import com.shownf.reptile.service.SaleHeartService;
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
public class SaleHeartController {

    SaleHeartService saleHeartService;

    @Autowired
    public SaleHeartController(SaleHeartService saleHeartService) {
        this.saleHeartService = saleHeartService;
    }

    // 분양글 좋아요 저장
    @PostMapping("saleHeart")
    public ResponseEntity<Map<String, Object>> saveSaleHeart(@RequestBody RequestSaleHeartSaveDTO RequestSaleHeartSaveDTO){
        Long saleHeartId = saleHeartService.saveSaleHeart(RequestSaleHeartSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (saleHeartId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (saleHeartId != null) ? "Save Success" : "Save Fail");
        requestMap.put("saleHeartId", saleHeartId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
