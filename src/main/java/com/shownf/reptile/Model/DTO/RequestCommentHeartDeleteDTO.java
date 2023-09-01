package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestCommentHeartDeleteDTO {
    Long commentHeartId;
    Long commentId;
    String userId;
}
