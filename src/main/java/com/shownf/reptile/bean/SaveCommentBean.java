package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.Model.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateCommentDAOBean createCommentDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;
    UpdatePostCommentCountDAOBean updatePostCommentCountDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SaveCommentBean(CreateUniqueIdBean createUniqueIdBean, CreateCommentDAOBean createCommentDAOBean, SaveCommentDAOBean saveCommentDAOBean, UpdatePostCommentCountDAOBean updatePostCommentCountDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createCommentDAOBean = createCommentDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
        this.updatePostCommentCountDAOBean = updatePostCommentCountDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    // 댓글 저장
    public Long exec(RequestCommentSaveDTO requestCommentSaveDTO){

        // postId 존재 확인이 필요할까?

        // commentId 생성
        long commentId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        CommentDAO commentDAO = createCommentDAOBean.exec(commentId, requestCommentSaveDTO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        // 댓글 저장에 따른 게시물 댓글 갯수 추가
        PostDAO postDAO = updatePostCommentCountDAOBean.exec(commentDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // 댓글 cId 반환
        return commentId;
    }
}
