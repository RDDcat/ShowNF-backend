package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.bean.small.CreateCommentDAOBean;
import com.shownf.reptile.bean.small.CreateUniqueIdBean;
import com.shownf.reptile.bean.small.SaveCommentDAOBean;
import com.shownf.reptile.entity.CommentDAO;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateCommentDAOBean createCommentDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public SaveCommentBean(CreateUniqueIdBean createUniqueIdBean, CreateCommentDAOBean createCommentDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createCommentDAOBean = createCommentDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    public Long exec(RequestCommentSaveDTO requestCommentSaveDTO){

        // pId 존재 확인이 필요할까?

        // cId 생성
        long cId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        CommentDAO commentDAO = createCommentDAOBean.exec(cId, requestCommentSaveDTO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        // 댓글 cId 반환
        return cId;
    }
}
