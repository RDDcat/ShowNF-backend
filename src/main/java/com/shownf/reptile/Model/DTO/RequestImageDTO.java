package com.shownf.reptile.Model.DTO;

import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class RequestImageDTO {
    @Id
    Long imageId;
    String imageName;
    String imageUrl;
    LocalDateTime uploadTime;
    Integer heartCount;
}
