package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestSaleHeartDeleteDTO {
    Long saleHeartId;
    Long saleId;
    String userId;
}
