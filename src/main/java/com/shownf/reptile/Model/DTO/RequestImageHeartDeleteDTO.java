package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestImageHeartDeleteDTO {
    Long imageHeartId;
    Long imageId;
    String userId;
}
