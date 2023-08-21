package com.shownf.reptile.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestPostDTO {
    long pId;
    String uId;
    String title;
    String content;
    String category;
    LocalDateTime uploadTime;
    Integer heartCount;
    Integer commentCount;
    Integer viewCount;
}
