package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.Model.entity.SaleHeartDAO;
import com.shownf.reptile.repository.SaleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateSaleHeartCountDAOBean {

    SaleRepositoryJPA saleRepositoryJPA;

    @Autowired
    public UpdateSaleHeartCountDAOBean(SaleRepositoryJPA saleRepositoryJPA) {
        this.saleRepositoryJPA = saleRepositoryJPA;
    }

    // 분양글 좋아요 갯수 추가
    public SaleDAO exec(SaleHeartDAO saleHeartDAO){

        // saleId 가져오기
        Long saleId = saleHeartDAO.getSaleId();

        // saleId 로 분양글 찾기
        SaleDAO saleDAO = saleRepositoryJPA.findById(saleId).get();

        // 분양글 좋아요 수 1 증가
        saleDAO.setHeartCount(saleDAO.getHeartCount() + 1);

        // 분양글 반환
        return saleDAO;
    }
}
