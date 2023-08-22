package com.shownf.reptile.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestCommentsDTO {
    Long cId;
    Long pId;
    String uId;
    String content;
    LocalDateTime uploadTime;
    Integer heartCount;
}
