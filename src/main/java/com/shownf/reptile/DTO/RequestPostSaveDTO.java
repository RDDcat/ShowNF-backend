package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestPostSaveDTO {
    String uId;
    String title;
    String content;
    String category;
}
