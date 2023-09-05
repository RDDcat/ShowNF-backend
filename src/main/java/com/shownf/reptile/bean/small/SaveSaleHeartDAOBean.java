package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleHeartDAO;
import com.shownf.reptile.repository.SaleHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleHeartDAOBean {

    SaleHeartRepositoryJPA saleHeartRepositoryJPA;

    @Autowired
    public SaveSaleHeartDAOBean(SaleHeartRepositoryJPA saleHeartRepositoryJPA) {
        this.saleHeartRepositoryJPA = saleHeartRepositoryJPA;
    }

    // 분양글 좋아요 저장
    public void exec(SaleHeartDAO saleHeartDAO){
        saleHeartRepositoryJPA.save(saleHeartDAO);
    }
}
