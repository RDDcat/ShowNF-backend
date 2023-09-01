package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class RequestReplyHeartDeleteDTO {
    Long replyHeartId;
    Long replyId;
    String userId;
}
