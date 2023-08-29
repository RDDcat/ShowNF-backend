package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.bean.small.CreatePostDAOBean;
import com.shownf.reptile.bean.small.CreateUniqueIdBean;
import com.shownf.reptile.bean.small.SavePostDAOBean;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePostDAOBean createPostDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SavePostBean(CreateUniqueIdBean createUniqueIdBean, CreatePostDAOBean createPostDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPostDAOBean = createPostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    public Long exec(RequestPostSaveDTO requestPostSaveDTO){
        // postId 생성
        long postId = createUniqueIdBean.exec();

        // DTO 객체 DAO 변환
        PostDAO postDAO = createPostDAOBean.exec(postId, requestPostSaveDTO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // 게시물 postId 반환
        return postId;
    }
}
