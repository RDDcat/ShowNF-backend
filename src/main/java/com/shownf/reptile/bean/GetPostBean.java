package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.bean.small.CheckUserIdPostDAOBean;
import com.shownf.reptile.bean.small.CreatePostDTOBean;
import com.shownf.reptile.bean.small.GetPostDAOBean;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostBean {
    GetPostDAOBean getPostDAOBean;
    CheckUserIdPostDAOBean checkUserIdPostDAOBean;
    CreatePostDTOBean createPostDTOBean;

    @Autowired
    public GetPostBean(GetPostDAOBean getPostDAOBean, CheckUserIdPostDAOBean checkUserIdPostDAOBean, CreatePostDTOBean createPostDTOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.checkUserIdPostDAOBean = checkUserIdPostDAOBean;
        this.createPostDTOBean = createPostDTOBean;
    }


    public RequestPostDTO exec(long pId, String uId){
        // pId 로 게시물 찾기
        PostDAO postDAO = getPostDAOBean.exec(pId);

        // uId 일치여부 확인
        if (!checkUserIdPostDAOBean.exec(postDAO, uId))
            return null;

        // DTO 에 게시물 객체 넘기기
        RequestPostDTO requestPostDTO = createPostDTOBean.exec(postDAO);

        // DTO 반환
        return requestPostDTO;
    }
}
