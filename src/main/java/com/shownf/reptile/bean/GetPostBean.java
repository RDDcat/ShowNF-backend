package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.bean.small.*;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostBean {
    GetPostDAOBean getPostDAOBean;
    CheckUserIdPostDAOBean checkUserIdPostDAOBean;
    UpdatePostViewCountDAOBean updatePostViewCountDAOBean;
    SavePostDAOBean savePostDAOBean;
    CreatePostDTOBean createPostDTOBean;

    @Autowired
    public GetPostBean(GetPostDAOBean getPostDAOBean, CheckUserIdPostDAOBean checkUserIdPostDAOBean, UpdatePostViewCountDAOBean updatePostViewCountDAOBean, SavePostDAOBean savePostDAOBean, CreatePostDTOBean createPostDTOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.checkUserIdPostDAOBean = checkUserIdPostDAOBean;
        this.updatePostViewCountDAOBean = updatePostViewCountDAOBean;
        this.savePostDAOBean = savePostDAOBean;
        this.createPostDTOBean = createPostDTOBean;
    }


    public RequestPostDTO exec(long pId, String uId){
        // pId 로 게시물 찾기
        PostDAO postDAO = getPostDAOBean.exec(pId);

        // uId 일치여부 확인
        if (!checkUserIdPostDAOBean.exec(postDAO, uId))
            return null;

        // 게시물 찾기로 인한 조회수 1 증가
        PostDAO findPostDAO = updatePostViewCountDAOBean.exec(postDAO);

        // 게시물 저장
        savePostDAOBean.exec(findPostDAO);

        // DTO 에 게시물 객체 넘기기
        RequestPostDTO requestPostDTO = createPostDTOBean.exec(findPostDAO);

        // DTO 반환
        return requestPostDTO;
    }
}
