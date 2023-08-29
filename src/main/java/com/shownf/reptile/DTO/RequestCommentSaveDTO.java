package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestCommentSaveDTO {
    Long postId;
    String userId;
    String content;
}
