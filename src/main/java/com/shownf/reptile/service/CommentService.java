package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestCommentDeleteDTO;
import com.shownf.reptile.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.DTO.RequestCommentsDTO;
import com.shownf.reptile.bean.DeleteCommentBean;
import com.shownf.reptile.bean.GetCommentsBean;
import com.shownf.reptile.bean.SaveCommentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    GetCommentsBean getCommentsBean;
    SaveCommentBean saveCommentBean;
    DeleteCommentBean deleteCommentBean;


    @Autowired
    public CommentService(GetCommentsBean getCommentsBean, SaveCommentBean saveCommentBean, DeleteCommentBean deleteCommentBean) {
        this.getCommentsBean = getCommentsBean;
        this.saveCommentBean = saveCommentBean;
        this.deleteCommentBean = deleteCommentBean;
    }

    // 댓글 전체 조회
    public List<RequestCommentsDTO> getComments(Long pId){
        return getCommentsBean.exec(pId);
    }

    // 댓글 저장
    public Long saveComment(RequestCommentSaveDTO requestCommentSaveDTO){
        return saveCommentBean.exec(requestCommentSaveDTO);
    }

    // 댓글 수정

    // 댓글 삭제
    public Long deleteComment(RequestCommentDeleteDTO requestCommentDeleteDTO){
        return deleteCommentBean.exec(requestCommentDeleteDTO);
    }

}
