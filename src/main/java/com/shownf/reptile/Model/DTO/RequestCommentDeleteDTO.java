package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestCommentDeleteDTO {
    Long commentId;
    Long postId;
    String userId;
}
