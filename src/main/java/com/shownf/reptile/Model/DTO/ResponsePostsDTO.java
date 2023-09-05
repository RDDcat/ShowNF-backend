package com.shownf.reptile.Model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponsePostsDTO {
    long postId;
    String userId;
    String title;
    String content;
    String category;
    LocalDateTime uploadTime;
    Integer heartCount;
    Integer commentCount;
    Integer viewCount;
}
