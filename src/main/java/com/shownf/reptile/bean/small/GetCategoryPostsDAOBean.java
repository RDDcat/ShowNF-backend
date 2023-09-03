package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.Enum.Category;
import com.shownf.reptile.Model.entity.PostDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetCategoryPostsDAOBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public GetCategoryPostsDAOBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // 카테고리별 게시물 찾기
    public Page<PostDAO> exec(String category, Pageable pageable){
        return postRepositoryJPA.findByCategory(Category.valueOf(category), pageable);
    }
}
