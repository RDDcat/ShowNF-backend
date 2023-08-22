package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestReplySaveDTO;
import com.shownf.reptile.bean.SaveReplyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    SaveReplyBean saveReplyBean;

    @Autowired
    public ReplyService(SaveReplyBean saveReplyBean) {
        this.saveReplyBean = saveReplyBean;
    }

    // 대댓글 저장
    public Long saveReply(RequestReplySaveDTO requestReplySaveDTO){
        return saveReplyBean.exec(requestReplySaveDTO);
    }
}
