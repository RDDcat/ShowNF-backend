package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestReplyHeartDeleteDTO;
import com.shownf.reptile.DTO.RequestReplyHeartSaveDTO;
import com.shownf.reptile.bean.DeleteReplyHeartBean;
import com.shownf.reptile.bean.SaveReplyHeartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyHeartService {

    SaveReplyHeartBean saveReplyHeartBean;
    DeleteReplyHeartBean deleteReplyHeartBean;

    @Autowired
    public ReplyHeartService(SaveReplyHeartBean saveReplyHeartBean, DeleteReplyHeartBean deleteReplyHeartBean) {
        this.saveReplyHeartBean = saveReplyHeartBean;
        this.deleteReplyHeartBean = deleteReplyHeartBean;
    }

    // 대댓글 좋아요 저장
    public Long saveReplyHeart(RequestReplyHeartSaveDTO requestReplyHeartSaveDTO){
        return saveReplyHeartBean.exec(requestReplyHeartSaveDTO);
    }

    // 대댓글 좋아요 삭제
    public Long deleteReplyHeart(RequestReplyHeartDeleteDTO requestReplyHeartDeleteDTO){
        return deleteReplyHeartBean.exec(requestReplyHeartDeleteDTO);
    }
}
