package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestCommentDeleteDTO {
    Long cId;
    Long pId;
    String uId;
}
