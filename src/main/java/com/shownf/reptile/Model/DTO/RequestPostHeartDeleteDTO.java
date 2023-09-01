package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestPostHeartDeleteDTO {
    Long postHeartId;
    Long postId;
    String userId;
}
