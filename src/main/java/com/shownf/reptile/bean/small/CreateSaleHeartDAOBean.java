package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestSaleHeartSaveDTO;
import com.shownf.reptile.Model.entity.SaleHeartDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateSaleHeartDAOBean {

    // 분양글 좋아요 저장시 DAO 생성
    public SaleHeartDAO exec(Long saleHeartId, RequestSaleHeartSaveDTO requestSaleHeartSaveDTO){

        // 분양글 아이디
        Long saleId = requestSaleHeartSaveDTO.getSaleId();

        // 유저 아이디
        String userId = requestSaleHeartSaveDTO.getUserId();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // DAO 반환
        return new SaleHeartDAO(saleHeartId, saleId, userId, uploadTime);
    }
}
