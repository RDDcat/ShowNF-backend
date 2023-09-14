package com.shownf.reptile.Model.entity;

import com.shownf.reptile.Model.Enum.Area;
import com.shownf.reptile.Model.Enum.Gender;
import com.shownf.reptile.Model.Enum.SalePlatform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleDAO {
    @Id
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
    SalePlatform salePlatform;
    String link;
    String refundPolicy;
    Boolean cites;
    Area area;
    String region;
    Gender gender;
}
