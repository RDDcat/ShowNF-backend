package com.shownf.reptile.service;

import com.shownf.reptile.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.bean.SaveCommentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    SaveCommentBean saveCommentBean;

    @Autowired
    public CommentService(SaveCommentBean saveCommentBean) {
        this.saveCommentBean = saveCommentBean;
    }

    // 댓글 전체 조회

    // 댓글 저장
    public Long saveComment(RequestCommentSaveDTO requestCommentSaveDTO){
        return saveCommentBean.exec(requestCommentSaveDTO);
    }

    // 댓글 수정

    // 댓글 삭제
}
