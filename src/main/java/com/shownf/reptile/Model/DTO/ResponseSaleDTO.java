package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class ResponseSaleDTO {
    Long saleId;
    Long petId;
    String userId;
    String imageUrl;
    String individual;
    String firstSpecies;
    String secondSpecies;
    String birthday;
    Double weight;
    String memo;
    Integer price;
    Integer heartCount;
    String salePlatform;
    String link;
    String refundPolicy;
    Boolean cites;
    String area;
    String region;
    String gender;
}
