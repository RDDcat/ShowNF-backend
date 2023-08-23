package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.bean.GetPostBean;
import com.shownf.reptile.bean.SavePostBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    GetPostBean getPostBean;
    SavePostBean savePostBean;

    @Autowired
    public PostService(GetPostBean getPostBean, SavePostBean savePostBean) {
        this.getPostBean = getPostBean;
        this.savePostBean = savePostBean;
    }

    // 게시물 조회
    public RequestPostDTO getPostDAO(long pId){
        return getPostBean.exec(pId);
    }

    // 게시물 저장
    public long savePostDAO(RequestPostSaveDTO requestPostSaveDTO){
        return  savePostBean.exec(requestPostSaveDTO);
    }

    // 게시물 수정

    // 게시물 삭제

}
