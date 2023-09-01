package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.bean.small.CreatePostsDTOBean;
import com.shownf.reptile.bean.small.GetPostsDAOBean;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetPostsBean {

    GetPostsDAOBean getPostsDAOBean;
    CreatePostsDTOBean createPostsDTOBean;

    @Autowired
    public GetPostsBean(GetPostsDAOBean getPostsDAOBean, CreatePostsDTOBean createPostsDTOBean) {
        this.getPostsDAOBean = getPostsDAOBean;
        this.createPostsDTOBean = createPostsDTOBean;
    }

    // 게시물 Page 형태로 전체 조회
    public Page<RequestPostDTO> exec(Pageable pageable){

        // 게시물 전체 찾기
        Page<PostDAO> postDAOs = getPostsDAOBean.exec(pageable);

        // DAO 객체 DTO 반환
        return createPostsDTOBean.exec(pageable, postDAOs);
    }
}
