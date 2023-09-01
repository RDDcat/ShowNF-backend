package com.shownf.reptile.Model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestCommentsDTO {
    Long commentId;
    Long postId;
    String userId;
    String content;
    LocalDateTime uploadTime;
    Integer heartCount;
    Integer replyCount;
}
