package com.shownf.reptile.Model.DTO;

import lombok.Data;


@Data
public class ResponseSalesDTO {
    Long saleId;
    String userId;
    String imageUrl;
    String individual;
    String firstSpecies;
    String secondSpecies;
    String birthday;
    Double weight;
    String speciesExplain;
    Integer price;
    Integer heartCount;
}
