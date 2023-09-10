package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestPetSaveDTO {
    String userId;
    String imageUrl;
    String name;
    String firstSpecies;
    String secondSpecies;
    String birthday;
    Double weight;
}
