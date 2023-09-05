package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestSaleHeartSaveDTO;
import com.shownf.reptile.bean.SaveSaleHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleHeartService {

    SaveSaleHeartBean saveSaleHeartBean;

    @Autowired
    public SaleHeartService(SaveSaleHeartBean saveSaleHeartBean) {
        this.saveSaleHeartBean = saveSaleHeartBean;
    }

    // 분양글 좋아요 저장
    public Long saveSaleHeart(RequestSaleHeartSaveDTO requestSaleHeartSaveDTO){
        return saveSaleHeartBean.exec(requestSaleHeartSaveDTO);
    }
}
