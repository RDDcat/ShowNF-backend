package com.shownf.reptile.Model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PetDAO {
    @Id
    Long petId;
    String userId;
    String imageUrl;
    String name;
    String firstSpecies;
    String secondSpecies;
    String birthday;
    Double weight;
    LocalDateTime uploadTime;
}
