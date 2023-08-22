package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestCommentHeartSaveDTO;
import com.shownf.reptile.bean.SaveCommentHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentHeartService {

    SaveCommentHeartBean saveCommentHeartBean;

    @Autowired
    public CommentHeartService(SaveCommentHeartBean saveCommentHeartBean) {
        this.saveCommentHeartBean = saveCommentHeartBean;
    }

    // 댓글 좋아요 저장
    public Long saveCommentHeart(RequestCommentHeartSaveDTO requestCommentHeartSaveDTO){
        return saveCommentHeartBean.exec(requestCommentHeartSaveDTO);
    }
}
