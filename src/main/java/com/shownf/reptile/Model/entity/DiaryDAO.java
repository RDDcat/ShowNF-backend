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
public class DiaryDAO {
    @Id
    Long diaryId;
    Long petId;
    String userId;
    String food;
    Integer foodCounter;
    String size;
    Double weight;
    String memo;
    LocalDateTime uploadTime;
}
