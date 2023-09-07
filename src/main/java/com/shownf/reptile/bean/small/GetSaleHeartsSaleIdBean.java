package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.SaleHeartDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSaleHeartsSaleIdBean {

    // 좋아요에서 분양글 아이디 가져오기
    public List<Long> exec(List<SaleHeartDAO> saleHeartDAOs){

        List<Long> saleIds = new ArrayList<>();

        for (SaleHeartDAO saleHeartDAO : saleHeartDAOs)
            saleIds.add(saleHeartDAO.getSaleId());

        return saleIds;
    }
}
