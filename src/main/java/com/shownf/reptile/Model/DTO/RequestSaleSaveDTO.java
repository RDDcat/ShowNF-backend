package com.shownf.reptile.Model.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestSaleSaveDTO {
    Long saleId;
    String userId;
    List<Map<String, String>> imageUrl;
    String individual;
    String firstSpecies;
    String secondSpecies;
    String birthday;
    Double weight;
    String speciesExplain;
    Integer price;
}
