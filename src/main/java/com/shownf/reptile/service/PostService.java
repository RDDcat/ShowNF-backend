package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.bean.GetPostBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    GetPostBean getPostBean;

    @Autowired
    public PostService(GetPostBean getPostBean) {
        this.getPostBean = getPostBean;
    }

    // 게시물 조회
    public RequestPostDTO getPostDAO(long pId, String uId){
        return getPostBean.exec(pId, uId);
    }


    // 게시물 저장

    // 게시물 수정

    // 게시물 삭제

}
