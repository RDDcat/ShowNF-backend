package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleHeartDAO;
import com.shownf.reptile.repository.SaleHeartRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSaleHeartsDAOBean {

    SaleHeartRepositoryJPA saleHeartRepositoryJPA;

    @Autowired
    public GetSaleHeartsDAOBean(SaleHeartRepositoryJPA saleHeartRepositoryJPA) {
        this.saleHeartRepositoryJPA = saleHeartRepositoryJPA;
    }

    // 좋아요 아이디로 좋아요 객체 찾기
    public List<SaleHeartDAO> exec(String userId){
        return saleHeartRepositoryJPA.findByUserId(userId);
    }
}
