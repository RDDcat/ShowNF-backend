package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.ResponseSalesDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.Model.entity.SaleHeartDAO;
import com.shownf.reptile.bean.small.CreateSalesDTOBean;
import com.shownf.reptile.bean.small.GetSaleHeartsDAOBean;
import com.shownf.reptile.bean.small.GetSaleHeartsSaleIdBean;
import com.shownf.reptile.bean.small.GetSalesDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserSaleHeartsBean {

    GetSaleHeartsDAOBean getSaleHeartsDAOBean;
    GetSaleHeartsSaleIdBean getSaleHeartsSaleIdBean;
    GetSalesDAOBean getSalesDAOBean;
    CreateSalesDTOBean createSalesDTOBean;

    @Autowired
    public GetUserSaleHeartsBean(GetSaleHeartsDAOBean getSaleHeartsDAOBean, GetSaleHeartsSaleIdBean getSaleHeartsSaleIdBean, GetSalesDAOBean getSalesDAOBean, CreateSalesDTOBean createSalesDTOBean) {
        this.getSaleHeartsDAOBean = getSaleHeartsDAOBean;
        this.getSaleHeartsSaleIdBean = getSaleHeartsSaleIdBean;
        this.getSalesDAOBean = getSalesDAOBean;
        this.createSalesDTOBean = createSalesDTOBean;
    }

    // 유저가 좋아요한 분양글 조회
    public List<ResponseSalesDTO> exec(String userId){

        // 유저 아이디를 통해 분양글 좋아요 객체 찾기
        List<SaleHeartDAO> saleHeartDAOs = getSaleHeartsDAOBean.exec(userId);

        // 좋아요 객체에서 분양글 아이디 찾기
        List<Long> saleIds = getSaleHeartsSaleIdBean.exec(saleHeartDAOs);

        // 분양글 아이디로 분양글 찾기
        List<SaleDAO> saleDAOs = getSalesDAOBean.exec(saleIds);

        // DAO 객체 DTO 로 반환
        return createSalesDTOBean.exec(saleDAOs);
    }
}
