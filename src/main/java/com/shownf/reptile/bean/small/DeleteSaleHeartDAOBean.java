package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleHeartDAO;
import com.shownf.reptile.repository.SaleHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteSaleHeartDAOBean {

    SaleHeartRepositoryJPA saleHeartRepositoryJPA;

    @Autowired
    public DeleteSaleHeartDAOBean(SaleHeartRepositoryJPA saleHeartRepositoryJPA) {
        this.saleHeartRepositoryJPA = saleHeartRepositoryJPA;
    }

    // 분양글 좋아요 삭제
    public void exec(SaleHeartDAO saleHeartDAO){
        saleHeartRepositoryJPA.delete(saleHeartDAO);
    }
}
