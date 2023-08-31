package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.PostContentDAO;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavePostBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePostContentsDAOBean createPostContentsDAOBean;
    SavePostContentsDAOBean savePostContentsDAOBean;
    CreatePostDAOBean createPostDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SavePostBean(CreateUniqueIdBean createUniqueIdBean, CreatePostContentsDAOBean createPostContentsDAOBean, SavePostContentsDAOBean savePostContentsDAOBean, CreatePostDAOBean createPostDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPostContentsDAOBean = createPostContentsDAOBean;
        this.savePostContentsDAOBean = savePostContentsDAOBean;
        this.createPostDAOBean = createPostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    public Long exec(RequestPostSaveDTO requestPostSaveDTO){
        // postId 생성
        long postId = createUniqueIdBean.exec();

        // postContent DAO 변환
        List<PostContentDAO> postContentDAOs = createPostContentsDAOBean.exec(postId, requestPostSaveDTO);

        // postContent 저장
        savePostContentsDAOBean.exec(postContentDAOs);

        // DTO 객체 DAO 변환
        PostDAO postDAO = createPostDAOBean.exec(postId, requestPostSaveDTO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // 게시물 postId 반환
        return postId;
    }
}
