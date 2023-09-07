package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestSaleHeartDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestSaleHeartSaveDTO;
import com.shownf.reptile.bean.DeleteSaleHeartBean;
import com.shownf.reptile.bean.SaveSaleHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleHeartService {

    SaveSaleHeartBean saveSaleHeartBean;
    DeleteSaleHeartBean deleteSaleHeartBean;

    @Autowired
    public SaleHeartService(SaveSaleHeartBean saveSaleHeartBean, DeleteSaleHeartBean deleteSaleHeartBean) {
        this.saveSaleHeartBean = saveSaleHeartBean;
        this.deleteSaleHeartBean = deleteSaleHeartBean;
    }

    // 분양글 좋아요 저장
    public Long saveSaleHeart(RequestSaleHeartSaveDTO requestSaleHeartSaveDTO){
        return saveSaleHeartBean.exec(requestSaleHeartSaveDTO);
    }

    // 분양글 좋아요 삭제
    public Long deleteSaleHeart(RequestSaleHeartDeleteDTO requestSaleHeartDeleteDTO){
        return deleteSaleHeartBean.exec(requestSaleHeartDeleteDTO);
    }
}
