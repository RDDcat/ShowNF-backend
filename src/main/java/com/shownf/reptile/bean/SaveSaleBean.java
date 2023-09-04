package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestSaleSaveDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.bean.small.CreateSaleDAOBean;
import com.shownf.reptile.bean.small.CreateUniqueIdBean;
import com.shownf.reptile.bean.small.SaveSaleDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateSaleDAOBean createSaleDAOBean;
    SaveSaleDAOBean saveSaleDAOBean;

    @Autowired
    public SaveSaleBean(CreateUniqueIdBean createUniqueIdBean, CreateSaleDAOBean createSaleDAOBean, SaveSaleDAOBean saveSaleDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createSaleDAOBean = createSaleDAOBean;
        this.saveSaleDAOBean = saveSaleDAOBean;
    }

    // 분양글 저장
    public Long exec(RequestSaleSaveDTO requestSaleSaveDTO){

        // saleId 생성
        Long saleId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        SaleDAO saleDAO = createSaleDAOBean.exec(saleId, requestSaleSaveDTO);

        // 분양글 저장
        saveSaleDAOBean.exec(saleDAO);

        // 분양글 saleId 반환
        return saleId;
    }
}
