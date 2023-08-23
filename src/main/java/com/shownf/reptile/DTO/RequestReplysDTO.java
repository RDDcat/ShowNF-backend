package com.shownf.reptile.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestReplysDTO {
    Long rId;
    Long cId;
    String uId;
    String content;
    LocalDateTime uploadTime;
    Integer heartCount;
}
