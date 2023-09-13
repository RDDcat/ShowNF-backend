package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.repository.SaleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSaleDAOBean {

    SaleRepositoryJPA saleRepositoryJPA;

    @Autowired
    public GetSaleDAOBean(SaleRepositoryJPA saleRepositoryJPA) {
        this.saleRepositoryJPA = saleRepositoryJPA;
    }

    // 분양글 찾기
    public SaleDAO exec(Long saleId){
        return saleRepositoryJPA.findById(saleId).get();
    }
}
