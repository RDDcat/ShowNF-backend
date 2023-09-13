package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.ResponseSaleDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.bean.small.CreateSalesDTOBean;
import com.shownf.reptile.bean.small.GetSalesDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetSalesBean {

    GetSalesDAOBean getSalesDAOBean;
    CreateSalesDTOBean createSalesDTOBean;

    @Autowired
    public GetSalesBean(GetSalesDAOBean getSalesDAOBean, CreateSalesDTOBean createSalesDTOBean) {
        this.getSalesDAOBean = getSalesDAOBean;
        this.createSalesDTOBean = createSalesDTOBean;
    }

    // 분양글 Page 형태로 전체 조회
    public Page<ResponseSaleDTO> exec(Pageable pageable){

        // 분양글 Page 형태로 전체 조회
        Page<SaleDAO> saleDAOs = getSalesDAOBean.exec(pageable);

        // DAO 객체 DTO 반환
        return createSalesDTOBean.exec(pageable, saleDAOs);
    }
}
