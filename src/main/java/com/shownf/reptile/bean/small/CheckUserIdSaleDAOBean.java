package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestSaleHeartDeleteDTO;
import com.shownf.reptile.Model.entity.SaleHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserIdSaleDAOBean {

    // 분양글 좋아요 userId 판별
    public boolean exec(SaleHeartDAO saleHeartDAO, RequestSaleHeartDeleteDTO requestSaleHeartDeleteDTO){
        if (saleHeartDAO.getUserId().equals(requestSaleHeartDeleteDTO.getUserId()))
            return true;
        return false;
    }
}
