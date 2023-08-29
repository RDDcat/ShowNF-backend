package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestPostSaveDTO {
    String userId;
    String title;
    String content;
    String category;
}
