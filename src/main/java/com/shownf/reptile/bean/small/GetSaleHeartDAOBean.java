package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleHeartDAO;
import com.shownf.reptile.repository.SaleHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSaleHeartDAOBean {

    SaleHeartRepositoryJPA saleHeartRepositoryJPA;

    @Autowired
    public GetSaleHeartDAOBean(SaleHeartRepositoryJPA saleHeartRepositoryJPA) {
        this.saleHeartRepositoryJPA = saleHeartRepositoryJPA;
    }

    // 분양글 좋아요 아이디로 객체 찾기
    public SaleHeartDAO exec(Long saleHeartId){
        return saleHeartRepositoryJPA.findById(saleHeartId).get();
    }
}
