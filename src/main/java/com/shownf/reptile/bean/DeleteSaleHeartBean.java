package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestSaleHeartDeleteDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import com.shownf.reptile.Model.entity.SaleHeartDAO;
import com.shownf.reptile.bean.small.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteSaleHeartBean {

    GetSaleHeartDAOBean getSaleHeartDAOBean;
    CheckSaleIdSaleDAOBean checkSaleIdSaleDAOBean;
    CheckUserIdSaleDAOBean checkUserIdSaleDAOBean;
    DeleteSaleHeartDAOBean deleteSaleHeartDAOBean;
    UpdateSaleHeartCountDAOBean updateSaleHeartCountDAOBean;
    SaveSaleDAOBean saveSaleDAOBean;

    @Autowired
    public DeleteSaleHeartBean(GetSaleHeartDAOBean getSaleHeartDAOBean, CheckSaleIdSaleDAOBean checkSaleIdSaleDAOBean, CheckUserIdSaleDAOBean checkUserIdSaleDAOBean, DeleteSaleHeartDAOBean deleteSaleHeartDAOBean, UpdateSaleHeartCountDAOBean updateSaleHeartCountDAOBean, SaveSaleDAOBean saveSaleDAOBean) {
        this.getSaleHeartDAOBean = getSaleHeartDAOBean;
        this.checkSaleIdSaleDAOBean = checkSaleIdSaleDAOBean;
        this.checkUserIdSaleDAOBean = checkUserIdSaleDAOBean;
        this.deleteSaleHeartDAOBean = deleteSaleHeartDAOBean;
        this.updateSaleHeartCountDAOBean = updateSaleHeartCountDAOBean;
        this.saveSaleDAOBean = saveSaleDAOBean;
    }

    // 분양글 좋아요 삭제
    public Long exec(RequestSaleHeartDeleteDTO requestSaleHeartDeleteDTO){

        // 분양글 좋아요 아이디 찾기
        Long saleHeartId = requestSaleHeartDeleteDTO.getSaleHeartId();

        // 아이디로 삭제할 좋아요 찾기
        SaleHeartDAO saleHeartDAO = getSaleHeartDAOBean.exec(saleHeartId);

        // 분양글 좋아요 해당하는 분양글 확인
        if (!checkSaleIdSaleDAOBean.exec(saleHeartDAO, requestSaleHeartDeleteDTO))
            return null;

        // 분양글 좋아요 해당하는 유저 확인
        if (!checkUserIdSaleDAOBean.exec(saleHeartDAO, requestSaleHeartDeleteDTO))
            return null;

        // 좋아요 삭제
        deleteSaleHeartDAOBean.exec(saleHeartDAO);

        // 분양글 좋아요 갯수 감소
        SaleDAO saleDAO = updateSaleHeartCountDAOBean.exec(saleHeartId, saleHeartDAO);

        // 분양글 저장
        saveSaleDAOBean.exec(saleDAO);

        // saleHeartId 반환
        return saleHeartId;
    }
}
