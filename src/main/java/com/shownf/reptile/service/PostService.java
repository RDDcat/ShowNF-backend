package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestPostDTO;
import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.Model.DTO.ResponsePostsDTO;
import com.shownf.reptile.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    GetPostBean getPostBean;
    GetPostsBean getHotPostsBean;
    GetCategoryPostsBean categoryPostsBean;
    GetUserPostHeartsBean getUserPostHeartsBean;
    SavePostBean savePostBean;

    @Autowired
    public PostService(GetPostBean getPostBean, GetPostsBean getHotPostsBean, GetCategoryPostsBean categoryPostsBean, GetUserPostHeartsBean getUserPostHeartsBean, SavePostBean savePostBean) {
        this.getPostBean = getPostBean;
        this.getHotPostsBean = getHotPostsBean;
        this.categoryPostsBean = categoryPostsBean;
        this.getUserPostHeartsBean = getUserPostHeartsBean;
        this.savePostBean = savePostBean;
    }

    // 게시물 조회
    public RequestPostDTO getPostDAO(Long postId){
        return getPostBean.exec(postId);
    }

    // 핫 게시물 조회
    public Page<RequestPostDTO> getHotPosts(Pageable pageable){
        return getHotPostsBean.exec(pageable);
    }

    // 카테고리별 게시물 조회
    public Page<RequestPostDTO> getCategoryPosts(String category, Pageable pageable){
        return categoryPostsBean.exec(category, pageable);
    }

    // 유저가 좋아요한 게시물 조회
    public List<ResponsePostsDTO> getUserPostHearts(String userId){
        return getUserPostHeartsBean.exec(userId);
    }

    // 게시물 저장
    public Long savePostDAO(RequestPostSaveDTO requestPostSaveDTO){
        return  savePostBean.exec(requestPostSaveDTO);
    }

    // 게시물 수정

    // 게시물 삭제

}
