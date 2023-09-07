package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestSaleHeartDeleteDTO;
import com.shownf.reptile.Model.entity.SaleHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckSaleIdSaleDAOBean {

    // 좋아요 saleId 판별
    public boolean exec(SaleHeartDAO saleHeartDAO, RequestSaleHeartDeleteDTO requestSaleHeartDeleteDTO){
        if (saleHeartDAO.getSaleId().equals(requestSaleHeartDeleteDTO.getSaleId()))
            return true;
        return false;
    }
}
