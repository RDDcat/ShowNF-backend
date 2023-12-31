package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestCommentDeleteDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.Model.entity.CommentDAO;
import com.shownf.reptile.Model.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentBean {

    GetCommentDAOBean getCommentDAOBean;
    CheckPostIdPostDAOBean checkPostIdPostDAOBean;
    CheckUserIdPostDAOBean checkUserIdPostDAOBean;
    DeleteCommentDAOBean deleteCommentDAOBean;
    UpdatePostCommentCountDAOBean updatePostCommentCountDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public DeleteCommentBean(GetCommentDAOBean getCommentDAOBean, CheckPostIdPostDAOBean checkPostIdPostDAOBean, CheckUserIdPostDAOBean checkUserIdPostDAOBean, DeleteCommentDAOBean deleteCommentDAOBean, UpdatePostCommentCountDAOBean updatePostCommentCountDAOBean, SavePostDAOBean savePostDAOBean) {
        this.getCommentDAOBean = getCommentDAOBean;
        this.checkPostIdPostDAOBean = checkPostIdPostDAOBean;
        this.checkUserIdPostDAOBean = checkUserIdPostDAOBean;
        this.deleteCommentDAOBean = deleteCommentDAOBean;
        this.updatePostCommentCountDAOBean = updatePostCommentCountDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    // 댓글 삭제
    public Long exec(RequestCommentDeleteDTO requestCommentDeleteDTO){

        // 댓글 아이디 찾기
        Long commentId = requestCommentDeleteDTO.getCommentId();

        // 아이디로 삭제할 댓글 찾기
        CommentDAO commentDAO =  getCommentDAOBean.exec(commentId);

        // 댓글에 해당하는 게시물 확인
        if (!checkPostIdPostDAOBean.exec(commentDAO, requestCommentDeleteDTO))
            return null;

        // 댓글에 해당하는 아이디 확인
        if (!checkUserIdPostDAOBean.exec(commentDAO, requestCommentDeleteDTO))
            return null;

        // 댓글 삭제
        deleteCommentDAOBean.exec(commentDAO);

        // 게시물 댓글 갯수 감소
        PostDAO postDAO = updatePostCommentCountDAOBean.exec(commentId, commentDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // commentId 반환
        return  commentId;
    }
}
