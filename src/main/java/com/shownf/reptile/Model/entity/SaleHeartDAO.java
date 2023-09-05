package com.shownf.reptile.Model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleHeartDAO {
    @Id
    Long saleHeartId;
    Long saleId;
    String userId;
    LocalDateTime uploadTime;
}
