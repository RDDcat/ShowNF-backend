package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestCommentHeartDeleteDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.CommentDAO;
import com.shownf.reptile.entity.CommentHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentHeartBean {

    GetCommentHeartDAOBean getCommentHeartDAOBean;
    CheckCommentIdCommentDAOBean checkCommentIdCommentDAOBean;
    CheckUserIdCommentDAOBean checkUserIdCommentDAOBean;
    DeleteCommentHeartDAOBean deleteCommentHeartDAOBean;
    UpdateCommentHeartCountDAOBean updateCommentHeartCountDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public DeleteCommentHeartBean(GetCommentHeartDAOBean getCommentHeartDAOBean, CheckCommentIdCommentDAOBean checkCommentIdCommentDAOBean, CheckUserIdCommentDAOBean checkUserIdCommentDAOBean, DeleteCommentHeartDAOBean deleteCommentHeartDAOBean, UpdateCommentHeartCountDAOBean updateCommentHeartCountDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.getCommentHeartDAOBean = getCommentHeartDAOBean;
        this.checkCommentIdCommentDAOBean = checkCommentIdCommentDAOBean;
        this.checkUserIdCommentDAOBean = checkUserIdCommentDAOBean;
        this.deleteCommentHeartDAOBean = deleteCommentHeartDAOBean;
        this.updateCommentHeartCountDAOBean = updateCommentHeartCountDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    public Long exec(RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO){

        // 댓글 좋아요 아이디 찾기
        Long commentHeartId = requestCommentHeartDeleteDTO.getCommentHeartId();

        // 아이디로 삭제할 좋아요 찾기
        CommentHeartDAO commentHeartDAO = getCommentHeartDAOBean.exec(commentHeartId);

        // 댓글 좋아요 해당하는 댓글 확인
        if (!checkCommentIdCommentDAOBean.exec(commentHeartDAO, requestCommentHeartDeleteDTO))
            return null;

        // 댓글 좋아요 해당하는 유저 확인
        if (!checkUserIdCommentDAOBean.exec(commentHeartDAO, requestCommentHeartDeleteDTO))
            return null;

        // 좋아요 삭제
        deleteCommentHeartDAOBean.exec(commentHeartDAO);

        // 댓글 좋아요 갯수 감소
        CommentDAO commentDAO = updateCommentHeartCountDAOBean.exec(commentHeartId, commentHeartDAO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        // commentHeartId 반환
        return commentHeartId;
    }
}
