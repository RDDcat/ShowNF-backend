package com.shownf.reptile.entity;

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
public class PostHeartDAO {
    @Id
    Long hId;
    Long pId;
    String uId;
    LocalDateTime uploadTime;
}
