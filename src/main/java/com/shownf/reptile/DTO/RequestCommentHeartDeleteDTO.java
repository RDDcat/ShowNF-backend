package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestCommentHeartDeleteDTO {
    Long cHId;
    Long cId;
    String uId;
}
