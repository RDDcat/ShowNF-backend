package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestSaleSaveDTO;
import com.shownf.reptile.Model.DTO.ResponseSaleDTO;
import com.shownf.reptile.bean.GetSaleBean;
import com.shownf.reptile.bean.GetSalesBean;
import com.shownf.reptile.bean.GetUserSaleHeartsBean;
import com.shownf.reptile.bean.SaveSaleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    GetSaleBean getSaleBean;
    GetSalesBean getSalesBean;
    GetUserSaleHeartsBean getUserSaleHeartsBean;
    SaveSaleBean saveSaleBean;

    @Autowired
    public SaleService(GetSaleBean getSaleBean, GetSalesBean getSalesBean, GetUserSaleHeartsBean getUserSaleHeartsBean, SaveSaleBean saveSaleBean) {
        this.getSaleBean = getSaleBean;
        this.getSalesBean = getSalesBean;
        this.getUserSaleHeartsBean = getUserSaleHeartsBean;
        this.saveSaleBean = saveSaleBean;
    }

    // 분양글 조회
    public ResponseSaleDTO getSale(Long saleId){
        return getSaleBean.exec(saleId);
    }

    // 분양글 Page 로 전체 조회
    public Page<ResponseSaleDTO> getSales(Pageable pageable){
        return getSalesBean.exec(pageable);
    }

    // 유저가 좋아요한 분양글 조회
    public List<ResponseSaleDTO> getUserSaleHearts(String userId){
        return getUserSaleHeartsBean.exec(userId);
    }

    // 분양글 저장
    public Long saveSale(RequestSaleSaveDTO requestSaleSaveDTO){
        return saveSaleBean.exec(requestSaleSaveDTO);
    }
}
