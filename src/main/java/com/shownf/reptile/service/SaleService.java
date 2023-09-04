package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestSaleSaveDTO;
import com.shownf.reptile.bean.SaveSaleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    SaveSaleBean saveSaleBean;

    @Autowired
    public SaleService(SaveSaleBean saveSaleBean) {
        this.saveSaleBean = saveSaleBean;
    }

    // 분양글 저장
    public Long saveSale(RequestSaleSaveDTO requestSaleSaveDTO){
        return saveSaleBean.exec(requestSaleSaveDTO);
    }
}
