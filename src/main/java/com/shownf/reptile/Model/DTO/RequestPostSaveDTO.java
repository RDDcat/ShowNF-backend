package com.shownf.reptile.Model.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RequestPostSaveDTO {
    String userId;
    String title;
    private List<Map<String, String>> content;
    String category;
}
