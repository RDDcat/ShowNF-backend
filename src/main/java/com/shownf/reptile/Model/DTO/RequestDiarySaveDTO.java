package com.shownf.reptile.Model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestDiarySaveDTO {
    Long petId;
    String userId;
    String food;
    Integer foodCounter;
    String size;
    Double weight;
    String memo;
    LocalDateTime uploadTime;
}
