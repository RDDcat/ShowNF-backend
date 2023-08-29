package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestReplyHeartDeleteDTO {
    Long replyHeartId;
    Long replyId;
    String userId;
}
