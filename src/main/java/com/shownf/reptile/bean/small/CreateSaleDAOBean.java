package com.shownf.reptile.bean.small;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shownf.reptile.Model.DTO.RequestSaleSaveDTO;
import com.shownf.reptile.Model.Enum.Area;
import com.shownf.reptile.Model.Enum.Gender;
import com.shownf.reptile.Model.Enum.SalePlatform;
import com.shownf.reptile.Model.entity.SaleDAO;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreateSaleDAOBean {

    // 분양글 작성시 DAO 생성
    public SaleDAO exec(Long saleId, RequestSaleSaveDTO requestSaleSaveDTO){

        // 마이펫 아이디 - NULL 가능
        Long petId = requestSaleSaveDTO.getPetId();

        // 유저 아이디
        String userId = requestSaleSaveDTO.getUserId();

        // 이미지 Url
        ObjectMapper objectMapper = new ObjectMapper();
        String imageUrl = "";
        try {
            imageUrl = objectMapper.writeValueAsString(requestSaleSaveDTO.getImageUrl());
        }catch (IOException e){
            e.printStackTrace();
        }
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

        // 좋아요 갯수
        Integer heartCount = 0;

        // 판매 플랫폼
        SalePlatform salePlatform = SalePlatform.valueOf(requestSaleSaveDTO.getSalePlatform());

        // 채팅, 네이버 링크
        String link = requestSaleSaveDTO.getLink();

        // 환불규정
        String refundPolicy = requestSaleSaveDTO.getRefundPolicy();

        // 사이테스 유무
        Boolean cites = requestSaleSaveDTO.getCites();

        // 행정구역
        Area area = Area.valueOf(requestSaleSaveDTO.getArea());

        // 지역
        String region = requestSaleSaveDTO.getRegion();

        // 성별
        Gender gender = Gender.valueOf(requestSaleSaveDTO.getGender());

        // DTO 반환
        return new SaleDAO(saleId, petId, userId, imageUrl, individual, firstSpecies, secondSpecies, birthday, weight, speciesExplain, price, heartCount, salePlatform, link, refundPolicy, cites, area, region, gender);
    }
}
