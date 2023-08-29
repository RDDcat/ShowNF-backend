package com.shownf.reptile.controller;

import com.shownf.reptile.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ImageController {

    ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // 이미지 저장
    @PostMapping("image")
    public String saveImage(@RequestParam("files")List<MultipartFile> files) throws IOException {
        imageService.saveImage(files);
        return "image_upload";

/*
        // HTTP 상태 변환
        HttpStatus httpStatus = (iId != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (iId != null) ? "Save Success" : "Save Fail");
        requestMap.put("iId", iId);

        return ResponseEntity.status(httpStatus).body(requestMap);*/
    }
}
