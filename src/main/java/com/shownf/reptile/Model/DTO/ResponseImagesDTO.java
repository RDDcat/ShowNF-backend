package com.shownf.reptile.Model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseImagesDTO {
    Long imageId;
    String imageName;
    String imageUrl;
    LocalDateTime uploadTime;
    Integer heartCount;
}
