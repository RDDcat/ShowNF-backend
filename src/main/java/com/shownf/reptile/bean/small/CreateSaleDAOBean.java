package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestSaleSaveDTO;
import com.shownf.reptile.Model.entity.SaleDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateSaleDAOBean {

    // 분양글 작성시 DAO 생성
    public SaleDAO exec(Long saleId, RequestSaleSaveDTO requestSaleSaveDTO){

        // 유저 아이디
        String userId = requestSaleSaveDTO.getUserId();

        // 이미지 Url
        String imageUrl = requestSaleSaveDTO.getImageUrl();

        // 개체
        String individual = requestSaleSaveDTO.getIndividual();

        // 첫번째 종
        String firstSpecies = requestSaleSaveDTO.getFirstSpecies();

        // 두번째 종
        String secondSpecies = requestSaleSaveDTO.getSecondSpecies();

        // 생일
        String birthday = requestSaleSaveDTO.getBirthday();

        // 체중
        Double weight = requestSaleSaveDTO.getWeight();

        // 개체 설명
        String speciesExplain = requestSaleSaveDTO.getSpeciesExplain();

        // 가격
        Integer price = requestSaleSaveDTO.getPrice();

        // DTO 반환
        return new SaleDAO(saleId, userId, imageUrl, individual, firstSpecies, secondSpecies, birthday, weight, speciesExplain, price);
    }
}
