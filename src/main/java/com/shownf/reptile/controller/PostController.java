package com.shownf.reptile.controller;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물 조회
    @GetMapping("post/{pId}/user/{uId}")
    public RequestPostDTO getPost(@PathVariable long pId, @PathVariable String uId){
        return postService.getPostDAO(pId, uId);
    }
}
