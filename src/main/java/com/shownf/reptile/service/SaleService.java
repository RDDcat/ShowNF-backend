package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestSaleSaveDTO;
import com.shownf.reptile.Model.DTO.ResponseSaleDTO;
import com.shownf.reptile.Model.DTO.ResponseSalesDTO;
import com.shownf.reptile.bean.GetSaleBean;
import com.shownf.reptile.bean.GetUserSaleHeartsBean;
import com.shownf.reptile.bean.SaveSaleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    GetSaleBean getSaleBean;
    GetUserSaleHeartsBean getUserSaleHeartsBean;
    SaveSaleBean saveSaleBean;

    @Autowired
    public SaleService(GetSaleBean getSaleBean, GetUserSaleHeartsBean getUserSaleHeartsBean, SaveSaleBean saveSaleBean) {
        this.getSaleBean = getSaleBean;
        this.getUserSaleHeartsBean = getUserSaleHeartsBean;
        this.saveSaleBean = saveSaleBean;
    }

    // 분양글 조회
    public ResponseSaleDTO getSale(Long saleId){
        return getSaleBean.exec(saleId);
    }

    // 유저가 좋아요한 분양글 조회
    public List<ResponseSalesDTO> getUserSaleHearts(String userId){
        return getUserSaleHeartsBean.exec(userId);
    }


    // 분양글 저장
    public Long saveSale(RequestSaleSaveDTO requestSaleSaveDTO){
        return saveSaleBean.exec(requestSaleSaveDTO);
    }
}
