package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.ResponseSalesDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateSalesDTOBean {

    // 분양글 아이디로 분양글 조회시 DTO 생성
    public List<ResponseSalesDTO> exec(List<SaleDAO> saleDAOs){

        List<ResponseSalesDTO> responseSalesDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (SaleDAO saleDAO: saleDAOs) {
            ResponseSalesDTO responseSalesDTO = new ResponseSalesDTO();

            responseSalesDTO.setSaleId(saleDAO.getSaleId());
            responseSalesDTO.setPetId(saleDAO.getPetId());
            responseSalesDTO.setUserId(saleDAO.getUserId());
            responseSalesDTO.setImageUrl(saleDAO.getImageUrl());
            responseSalesDTO.setIndividual(saleDAO.getIndividual());
            responseSalesDTO.setFirstSpecies(saleDAO.getFirstSpecies());
            responseSalesDTO.setSecondSpecies(saleDAO.getSecondSpecies());
            responseSalesDTO.setHeartCount(saleDAO.getHeartCount());
            responseSalesDTO.setBirthday(saleDAO.getBirthday());
            responseSalesDTO.setWeight(saleDAO.getWeight());
            responseSalesDTO.setSpeciesExplain(saleDAO.getSpeciesExplain());
            responseSalesDTO.setPrice(saleDAO.getPrice());
            responseSalesDTO.setHeartCount(saleDAO.getHeartCount());
            responseSalesDTO.setSalePlatform(saleDAO.getSalePlatform().name());

            responseSalesDTOs.add(responseSalesDTO);
        }

        // DTO 반환
        return responseSalesDTOs;
    }
}
