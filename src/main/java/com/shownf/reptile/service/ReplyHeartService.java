package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestReplyHeartSaveDTO;
import com.shownf.reptile.bean.SaveReplyHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyHeartService {

    SaveReplyHeartBean saveReplyHeartBean;

    @Autowired
    public ReplyHeartService(SaveReplyHeartBean saveReplyHeartBean) {
        this.saveReplyHeartBean = saveReplyHeartBean;
    }

    // 대댓글 좋아요 저장
    public Long saveReplyHeart(RequestReplyHeartSaveDTO requestReplyHeartSaveDTO){
        return saveReplyHeartBean.exec(requestReplyHeartSaveDTO);
    }

    // 대댓글 좋아요 삭제
}
