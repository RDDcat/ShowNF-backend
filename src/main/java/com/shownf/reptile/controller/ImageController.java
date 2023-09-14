package com.shownf.reptile.controller;

import com.shownf.reptile.Model.DTO.RequestImageDTO;
import com.shownf.reptile.Model.DTO.ResponseImagesDTO;
import com.shownf.reptile.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    // 스와이프 이미지 조회
    @GetMapping("image")
    public Page<RequestImageDTO> getImages(@PageableDefault(size=5, sort="uploadTime", direction = Sort.Direction.DESC) Pageable pageable){
        return imageService.getImages(pageable);
    }

    // 유저가 좋아요한 이미지 조회
    @GetMapping("image/user/{userId}")
    public List<ResponseImagesDTO> getUserImageHearts(@PathVariable String userId){
        return imageService.getUserImageHearts(userId);
    }

    // 이미지 저장
    @PostMapping("image")
    public String saveImage(@RequestParam("file")MultipartFile file) throws IOException {
        return imageService.saveImage(file);

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
