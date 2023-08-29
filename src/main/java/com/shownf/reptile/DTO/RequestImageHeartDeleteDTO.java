package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestImageHeartDeleteDTO {
    Long imageHeartId;
    Long imageId;
    String userId;
}
