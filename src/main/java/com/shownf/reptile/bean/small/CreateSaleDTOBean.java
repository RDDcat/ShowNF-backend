package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.ResponseSaleDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateSaleDTOBean {

    // 분양글 조회 시 DTO 생성
    public ResponseSaleDTO exec(SaleDAO saleDAO){
        ResponseSaleDTO responseSaleDTO = new ResponseSaleDTO();

        // DTO 객체에 분양글 정보 넘기기
        responseSaleDTO.setSaleId(saleDAO.getSaleId());
        responseSaleDTO.setPetId(saleDAO.getPetId());
        responseSaleDTO.setUserId(saleDAO.getUserId());
        responseSaleDTO.setImageUrl(saleDAO.getImageUrl());
        responseSaleDTO.setIndividual(saleDAO.getIndividual());
        responseSaleDTO.setFirstSpecies(saleDAO.getFirstSpecies());
        responseSaleDTO.setSecondSpecies(saleDAO.getSecondSpecies());
        responseSaleDTO.setHeartCount(saleDAO.getHeartCount());
        responseSaleDTO.setBirthday(saleDAO.getBirthday());
        responseSaleDTO.setWeight(saleDAO.getWeight());
        responseSaleDTO.setSpeciesExplain(saleDAO.getSpeciesExplain());
        responseSaleDTO.setPrice(saleDAO.getPrice());
        responseSaleDTO.setHeartCount(saleDAO.getHeartCount());
        responseSaleDTO.setSalePlatform(saleDAO.getSalePlatform().name());

        return responseSaleDTO;
    }
}
