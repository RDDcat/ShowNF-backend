package com.shownf.reptile.DTO;

import lombok.Data;

@Data
public class RequestReplySaveDTO {
    Long commentId;
    String userId;
    String content;
}
