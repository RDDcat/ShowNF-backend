package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.repository.SaleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSalesDAOBean {

    SaleRepositoryJPA saleRepositoryJPA;

    @Autowired
    public GetSalesDAOBean(SaleRepositoryJPA saleRepositoryJPA) {
        this.saleRepositoryJPA = saleRepositoryJPA;
    }

    // 분양글 아이디로 분양글 찾기
    public List<SaleDAO> exec(List<Long> saleIds){

        List<SaleDAO> saleDAOs = new ArrayList<>();

        for (Long saleId : saleIds)
            saleDAOs.add(saleRepositoryJPA.findById(saleId).get());

        return saleDAOs;
    }

    // 분양글 Page 형태로 전체 조회
    public Page<SaleDAO> exec(Pageable pageable){
        return saleRepositoryJPA.findAll(pageable);
    }
}
