package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestPostHeartSaveDTO;
import com.shownf.reptile.bean.DeletePostHeartBean;
import com.shownf.reptile.bean.SavePostHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostHeartService {

    SavePostHeartBean savePostHeartBean;
    DeletePostHeartBean deletePostHeartBean;

    @Autowired
    public PostHeartService(SavePostHeartBean savePostHeartBean, DeletePostHeartBean deletePostHeartBean) {
        this.savePostHeartBean = savePostHeartBean;
        this.deletePostHeartBean =deletePostHeartBean;
    }

    // 게시물 좋아요 저장
    public Long savePostHeart(RequestPostHeartSaveDTO requestPostHeartDTO){
        return savePostHeartBean.exec(requestPostHeartDTO);
    }

    // 게시물 좋아요 삭제
    public Long deletePostHeart(RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){
        return deletePostHeartBean.exec(requestPostHeartDeleteDTO);
    }
}
