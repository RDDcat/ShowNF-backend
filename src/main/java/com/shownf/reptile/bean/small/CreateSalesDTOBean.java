package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.ResponseSaleDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateSalesDTOBean {

    // 분양글 아이디로 분양글 조회시 DTO 생성
    public List<ResponseSaleDTO> exec(List<SaleDAO> saleDAOs){

        List<ResponseSaleDTO> responseSalesDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (SaleDAO saleDAO: saleDAOs) {
            ResponseSaleDTO responseSaleDTO = new ResponseSaleDTO();

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

            responseSalesDTOs.add(responseSaleDTO);
        }

        // DTO 반환
        return responseSalesDTOs;
    }

    // 분양글 Page 형태로 전체 조회시 DTO 생성
    public Page<ResponseSaleDTO> exec(Pageable pageable, Page<SaleDAO> saleDAOs){

        List<ResponseSaleDTO> responseSaleDTOs = new ArrayList<>();

        // DTO 객체에 분양글 정보 넘기기
        for (SaleDAO saleDAO: saleDAOs) {
            ResponseSaleDTO responseSaleDTO = new ResponseSaleDTO();

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

            responseSaleDTOs.add(responseSaleDTO);
        }

        // List 구조를 Page 구조로 변경 후 반환
        return new PageImpl<>(responseSaleDTOs, pageable, saleDAOs.getTotalElements());
    }
}
