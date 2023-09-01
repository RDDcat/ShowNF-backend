package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestReplyDeleteDTO {
    Long replyId;
    Long commentId;
    String userId;
}
