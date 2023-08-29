package com.shownf.reptile.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestReplysDTO {
    Long replyId;
    Long commentId;
    String userId;
    String content;
    LocalDateTime uploadTime;
    Integer heartCount;
}
