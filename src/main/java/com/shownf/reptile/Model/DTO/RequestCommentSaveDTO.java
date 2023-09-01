package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestCommentSaveDTO {
    Long postId;
    String userId;
    String content;
}
