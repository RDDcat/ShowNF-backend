package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestPostHeartDeleteDTO {
    Long postHeartId;
    Long postId;
    String userId;
}
