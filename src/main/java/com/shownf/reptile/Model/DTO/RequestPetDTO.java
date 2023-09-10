package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestPetDTO {
    Long petId;
    String userId;
    String imageUrl;
    String name;
    String firstSpecies;
    String secondSpecies;
    String birthday;
    Double weight;
}
