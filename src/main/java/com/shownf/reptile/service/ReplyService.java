package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestReplyDeleteDTO;
import com.shownf.reptile.DTO.RequestReplySaveDTO;
import com.shownf.reptile.bean.DeleteReplyBean;
import com.shownf.reptile.bean.SaveReplyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    SaveReplyBean saveReplyBean;
    DeleteReplyBean deleteReplyBean;

    @Autowired
    public ReplyService(SaveReplyBean saveReplyBean, DeleteReplyBean deleteReplyBean) {
        this.saveReplyBean = saveReplyBean;
        this.deleteReplyBean = deleteReplyBean;
    }

    // 대댓글 저장
    public Long saveReply(RequestReplySaveDTO requestReplySaveDTO){
        return saveReplyBean.exec(requestReplySaveDTO);
    }

    // 대댓글 삭제
    public Long deleteReply(RequestReplyDeleteDTO requestReplyDeleteDTO){
        return deleteReplyBean.exec(requestReplyDeleteDTO);
    }

}
