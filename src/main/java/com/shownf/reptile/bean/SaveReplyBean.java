package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestReplySaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.CommentDAO;
import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.entity.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveReplyBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateReplyDAOBean createReplyDAOBean;
    SaveReplyDAOBean saveReplyDAOBean;
    UpdateCommentReplyCountDAOBean updateCommentReplyCountDAOBean;
    UpdatePostCommentCountDAOBean updatePostCommentCountDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SaveReplyBean(CreateUniqueIdBean createUniqueIdBean, CreateReplyDAOBean createReplyDAOBean, SaveReplyDAOBean saveReplyDAOBean, UpdateCommentReplyCountDAOBean updateCommentReplyCountDAOBean, UpdatePostCommentCountDAOBean updatePostCommentCountDAOBean, SaveCommentDAOBean saveCommentDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createReplyDAOBean = createReplyDAOBean;
        this.saveReplyDAOBean = saveReplyDAOBean;
        this.updateCommentReplyCountDAOBean = updateCommentReplyCountDAOBean;
        this.updatePostCommentCountDAOBean = updatePostCommentCountDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    // 대댓글 저장
    public Long exec(RequestReplySaveDTO requestReplySaveDTO){

        // replyId 생성
        Long replyId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        ReplyDAO replyDAO = createReplyDAOBean.exec(replyId, requestReplySaveDTO);

        // 대댓글 저장
        saveReplyDAOBean.exec(replyDAO);

        // 대댓글 저장에 따른 댓글 대댓글 갯수 추가
        CommentDAO commentDAO = updateCommentReplyCountDAOBean.exec(replyDAO);

        // 대댓글 저장에 따른 게시물 댓글 갯수 추가
        PostDAO postDAO = updatePostCommentCountDAOBean.exec(commentDAO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // 대댓글 replyId 반환
        return replyId;
    }
}
