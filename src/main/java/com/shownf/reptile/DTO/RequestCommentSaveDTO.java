package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestCommentSaveDTO {
    Long pId;
    String uId;
    String content;
}
