package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestPostHeartSaveDTO;
import com.shownf.reptile.bean.SavePostHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostHeartService {

    SavePostHeartBean savePostHeartBean;

    @Autowired
    public PostHeartService(SavePostHeartBean savePostHeartBean) {
        this.savePostHeartBean = savePostHeartBean;
    }

    // 게시물 좋아요 저장
    public Long savePostHeart(RequestPostHeartSaveDTO requestPostHeartDTO){
        return savePostHeartBean.exec(requestPostHeartDTO);
    }
}
