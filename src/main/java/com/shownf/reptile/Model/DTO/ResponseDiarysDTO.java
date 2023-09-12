package com.shownf.reptile.Model.DTO;

import lombok.Data;

@Data
public class ResponseDiarysDTO {
    Long diaryId;
    Long petId;
    String userId;
    String date;
}
