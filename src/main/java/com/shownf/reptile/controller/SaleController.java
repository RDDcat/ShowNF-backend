package com.shownf.reptile.controller;

import com.shownf.reptile.Model.DTO.RequestSaleSaveDTO;
import com.shownf.reptile.Model.DTO.ResponseSalesDTO;
import com.shownf.reptile.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class SaleController {

    SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    // 유저가 좋아요한 분양글 조회
    @GetMapping("sale/user/{userId}")
    public List<ResponseSalesDTO> getUserSaleHearts(@PathVariable String userId){
        return saleService.getUserSaleHearts(userId);
    }

    // 분양글 저장
    @PostMapping("sale")
    public ResponseEntity<Map<String, Object>> saveSale(@RequestBody RequestSaleSaveDTO requestSaleSaveDTO){
        Long saleId = saleService.saveSale(requestSaleSaveDTO);

        // HTTP 상태 변환
        HttpStatus httpStatus = (saleId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (saleId != null) ? "Save Success" : "Save Fail");
        requestMap.put("saleId", saleId);

        return ResponseEntity.status(httpStatus).body(requestMap);
    }
}
