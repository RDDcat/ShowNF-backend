package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPostDTO;
import com.shownf.reptile.Model.entity.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class CreatePostDTOBean {

    // 게시물 조회시 DTO 생성
    public RequestPostDTO exec(PostDAO postDAO){
        RequestPostDTO requestPostDTO = new RequestPostDTO();

        // DTO 객체에 게시물 정보 넘기기
        requestPostDTO.setPostId(postDAO.getPostId());
        requestPostDTO.setUserId(postDAO.getUserId());
        requestPostDTO.setTitle(postDAO.getTitle());
        requestPostDTO.setContent(postDAO.getContent());
        requestPostDTO.setCategory(postDAO.getCategory().name());
        requestPostDTO.setUploadTime(postDAO.getUploadTime());
        requestPostDTO.setHeartCount(postDAO.getHeartCount());
        requestPostDTO.setCommentCount(postDAO.getCommentCount());
        requestPostDTO.setViewCount(postDAO.getViewCount());

        // DTO 반환
        return requestPostDTO;
    }
}
