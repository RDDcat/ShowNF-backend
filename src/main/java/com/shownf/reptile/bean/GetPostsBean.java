package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.entity.PostDAO;
import com.shownf.reptile.repository.PostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetHotPostsBean {

    PostRepositoryJPA postRepositoryJPA;

    @Autowired
    public GetHotPostsBean(PostRepositoryJPA postRepositoryJPA) {
        this.postRepositoryJPA = postRepositoryJPA;
    }

    // Hot 게시물 조회
    public Page<RequestPostDTO> exec(Pageable pageable){
        Page<PostDAO> postDAOs = postRepositoryJPA.findAll(pageable);

        List<RequestPostDTO> requestPostDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (PostDAO postDAO: postDAOs) {
            RequestPostDTO requestPostDTO = new RequestPostDTO();

            requestPostDTO.setPostId(postDAO.getPostId());
            requestPostDTO.setUserId(postDAO.getUserId());
            requestPostDTO.setTitle(postDAO.getTitle());
            requestPostDTO.setContent(postDAO.getContent());
            requestPostDTO.setCategory(postDAO.getCategory());
            requestPostDTO.setUploadTime(postDAO.getUploadTime());

            if (postDAO.getHeartCount() <= 0)
                continue;

            requestPostDTO.setHeartCount(postDAO.getHeartCount());
            requestPostDTO.setCommentCount(postDAO.getCommentCount());
            requestPostDTO.setViewCount(postDAO.getViewCount());

            requestPostDTOs.add(requestPostDTO);
        }

        return new PageImpl<>(requestPostDTOs, pageable, postDAOs.getTotalElements());
    }
}
