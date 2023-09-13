package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.ResponseSaleDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.bean.small.CreateSaleDTOBean;
import com.shownf.reptile.bean.small.GetSaleDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSaleBean {

    GetSaleDAOBean getSaleDAOBean;
    CreateSaleDTOBean createSaleDTOBean;

    @Autowired
    public GetSaleBean(GetSaleDAOBean getSaleDAOBean, CreateSaleDTOBean createSaleDTOBean) {
        this.getSaleDAOBean = getSaleDAOBean;
        this.createSaleDTOBean = createSaleDTOBean;
    }

    // 분양글 조회
    public ResponseSaleDTO exec(Long saleId){

        // saleId로 분양글 찾기
        SaleDAO saleDAO = getSaleDAOBean.exec(saleId);

        // 분양글 객체 DTO 변환 후 반환
        return createSaleDTOBean.exec(saleDAO);
    }
}
