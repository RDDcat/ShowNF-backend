package com.shownf.reptile.Model.DTO;

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
