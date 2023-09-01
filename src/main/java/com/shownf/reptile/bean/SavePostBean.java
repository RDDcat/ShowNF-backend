package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.Model.entity.PostContentDAO;
import com.shownf.reptile.Model.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavePostBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePostContentsDAOBean createPostContentsDAOBean;
    SavePostContentsDAOBean savePostContentsDAOBean;
    CreateImagesDAOBean createImagesDAOBean;
    SaveImagesDAOBean saveImagesDAOBean;
    CreatePostDAOBean createPostDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SavePostBean(CreateUniqueIdBean createUniqueIdBean, CreatePostContentsDAOBean createPostContentsDAOBean, SavePostContentsDAOBean savePostContentsDAOBean, CreateImagesDAOBean createImagesDAOBean, SaveImagesDAOBean saveImagesDAOBean, CreatePostDAOBean createPostDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPostContentsDAOBean = createPostContentsDAOBean;
        this.savePostContentsDAOBean = savePostContentsDAOBean;
        this.createImagesDAOBean = createImagesDAOBean;
        this.saveImagesDAOBean = saveImagesDAOBean;
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

        // 이미지 DAO 변환
        List<ImageDAO> imageDAOs = createImagesDAOBean.exec(requestPostSaveDTO);

        // 이미지 저장
        saveImagesDAOBean.exec(imageDAOs);

        // DTO 객체 DAO 변환
        PostDAO postDAO = createPostDAOBean.exec(postId, requestPostSaveDTO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // 게시물 postId 반환
        return postId;
    }
}
