package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestReplyDeleteDTO;
import com.shownf.reptile.Model.DTO.RequestReplySaveDTO;
import com.shownf.reptile.Model.DTO.RequestReplysDTO;
import com.shownf.reptile.bean.DeleteReplyBean;
import com.shownf.reptile.bean.GetReplysBean;
import com.shownf.reptile.bean.SaveReplyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    GetReplysBean getReplysBean;
    SaveReplyBean saveReplyBean;
    DeleteReplyBean deleteReplyBean;

    @Autowired
    public ReplyService(GetReplysBean getReplysBean, SaveReplyBean saveReplyBean, DeleteReplyBean deleteReplyBean) {
        this.getReplysBean = getReplysBean;
        this.saveReplyBean = saveReplyBean;
        this.deleteReplyBean = deleteReplyBean;
    }

    // 대댓글 전체 조회
    public List<RequestReplysDTO> getReplys(Long commentId){
        return getReplysBean.exec(commentId);
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
