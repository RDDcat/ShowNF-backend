package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestCommentHeartSaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.CommentDAO;
import com.shownf.reptile.entity.CommentHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentHeartBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateCommentHeartDAOBean createCommentHeartDAOBean;
    SaveCommentHeartDAOBean saveCommentHeartDAOBean;
    UpdateCommentHeartCountDAOBean updateCommentHeartCountDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public SaveCommentHeartBean(CreateUniqueIdBean createUniqueIdBean, CreateCommentHeartDAOBean createCommentHeartDAOBean, SaveCommentHeartDAOBean saveCommentHeartDAOBean, UpdateCommentHeartCountDAOBean updateCommentHeartCountDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createCommentHeartDAOBean = createCommentHeartDAOBean;
        this.saveCommentHeartDAOBean = saveCommentHeartDAOBean;
        this.updateCommentHeartCountDAOBean = updateCommentHeartCountDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    // 댓글 좋아요 저장
    public Long exec(RequestCommentHeartSaveDTO requestCommentHeartSaveDTO) {

        // commentHeartId 생성
        Long commentHeartId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        CommentHeartDAO commentHeartDAO = createCommentHeartDAOBean.exec(commentHeartId, requestCommentHeartSaveDTO);

        // 댓글 좋아요 저장
        saveCommentHeartDAOBean.exec(commentHeartDAO);

        // 댓글 좋아요 갯수 추가
        CommentDAO commentDAO = updateCommentHeartCountDAOBean.exec(commentHeartDAO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        // commentHeartId 반환
        return commentHeartId;
    }
}
