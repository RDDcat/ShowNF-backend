package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.repository.SaleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleDAOBean {

    SaleRepositoryJPA saleRepositoryJPA;

    @Autowired
    public SaveSaleDAOBean(SaleRepositoryJPA saleRepositoryJPA) {
        this.saleRepositoryJPA = saleRepositoryJPA;
    }

    // 분양글 저장
    public void exec(SaleDAO saleDAO){
        saleRepositoryJPA.save(saleDAO);
    }
}
