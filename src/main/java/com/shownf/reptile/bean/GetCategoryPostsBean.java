package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestPostDTO;
import com.shownf.reptile.Model.entity.PostDAO;
import com.shownf.reptile.bean.small.CreatePostsDTOBean;
import com.shownf.reptile.bean.small.GetCategoryPostsDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class GetCategoryPostsBean {

    GetCategoryPostsDAOBean getCategoryPostsDAOBean;
    CreatePostsDTOBean createPostsDTOBean;

    @Autowired
    public GetCategoryPostsBean(GetCategoryPostsDAOBean getCategoryPostsDAOBean, CreatePostsDTOBean createPostsDTOBean) {
        this.getCategoryPostsDAOBean = getCategoryPostsDAOBean;
        this.createPostsDTOBean = createPostsDTOBean;
    }

    // 카테고리별로 게시물 전체 조회
    public Page<RequestPostDTO> exec(String category, Pageable pageable){

        // 카테고리 찾기
        Page<PostDAO> postDAOs = getCategoryPostsDAOBean.exec(category, pageable);

        // DAO 객체 DTO 반환
        return createPostsDTOBean.exec(category, pageable, postDAOs);
    }
}
