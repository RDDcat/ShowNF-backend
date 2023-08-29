package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostHeartSaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostHeartBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePostHeartDAOBean createPostHeartDAOBean;
    SavePostHeartDAOBean savePostHeartDAOBean;
    UpdatePostHeartCountDAOBean updatePostHeartCountDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SavePostHeartBean(CreateUniqueIdBean createUniqueIdBean, CreatePostHeartDAOBean createPostHeartDAOBean, SavePostHeartDAOBean savePostHeartDAOBean, UpdatePostHeartCountDAOBean updatePostHeartCountDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPostHeartDAOBean = createPostHeartDAOBean;
        this.savePostHeartDAOBean = savePostHeartDAOBean;
        this.updatePostHeartCountDAOBean = updatePostHeartCountDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    public Long exec(RequestPostHeartSaveDTO requestPostHeartSaveDTO){

        // postHeartId 생성
        Long postHeartId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        PostHeartDAO postHeartDAO = createPostHeartDAOBean.exec(postHeartId, requestPostHeartSaveDTO);

        // 좋아요 저장
        savePostHeartDAOBean.exec(postHeartDAO);

        // 게시물 좋아요 갯수 추가
        PostDAO postDAO = updatePostHeartCountDAOBean.exec(postHeartDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // postHeartId 반환
        return postHeartId;
    }
}
