package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostHeartDeleteDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePostHeartBean {

    GetPostHeartDAOBean getPostHeartDAOBean;
    CheckPostIdPostDAOBean checkPostIdPostDAOBean;
    CheckUserIdPostDAOBean checkUserIdPostDAOBean;
    DeletePostHeartDAOBean deletePostHeartDAOBean;
    UpdatePostHeartCountDAOBean updatePostHeartCountDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public DeletePostHeartBean(GetPostHeartDAOBean getPostHeartDAOBean, CheckPostIdPostDAOBean checkPostIdPostDAOBean, CheckUserIdPostDAOBean checkUserIdPostDAOBean, DeletePostHeartDAOBean deletePostHeartDAOBean, UpdatePostHeartCountDAOBean updatePostHeartCountDAOBean, SavePostDAOBean savePostDAOBean) {
        this.getPostHeartDAOBean = getPostHeartDAOBean;
        this.checkPostIdPostDAOBean = checkPostIdPostDAOBean;
        this.checkUserIdPostDAOBean = checkUserIdPostDAOBean;
        this.deletePostHeartDAOBean = deletePostHeartDAOBean;
        this.updatePostHeartCountDAOBean = updatePostHeartCountDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    public Long exec(RequestPostHeartDeleteDTO requestPostHeartDeleteDTO){

        // 좋아요 아이디 찾기
        Long hId = requestPostHeartDeleteDTO.getHId();

        // 아이디로 삭제할 좋아요 찾기
        PostHeartDAO postHeartDAO = getPostHeartDAOBean.exec(hId);

        // 좋아요 해당하는 게시물 확인
        if (!checkPostIdPostDAOBean.exec(postHeartDAO, requestPostHeartDeleteDTO))
            return null;

        // 좋아요 해당하는 유저 확인
        if (!checkUserIdPostDAOBean.exec(postHeartDAO, requestPostHeartDeleteDTO))
            return null;

        // 좋아요 삭제
        deletePostHeartDAOBean.exec(postHeartDAO);

        // 게시물 좋아요 갯수 감소
        PostDAO postDAO = updatePostHeartCountDAOBean.exec(hId, postHeartDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // hId 반환
        return hId;
    }
}
