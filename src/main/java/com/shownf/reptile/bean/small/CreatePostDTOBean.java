package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestPostDTO;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class CreatePostDTOBean {

    // 게시물 조회시 DTO 생성
    public RequestPostDTO exec(PostDAO postDAO){
        RequestPostDTO requestPostDTO = new RequestPostDTO();

        // DTO 객체에 게시물 정보 넘기기
        requestPostDTO.setPId(postDAO.getPId());
        requestPostDTO.setUId(postDAO.getUId());
        requestPostDTO.setTitle(postDAO.getTitle());
        requestPostDTO.setContent(postDAO.getContent());
        requestPostDTO.setCategory(postDAO.getCategory());
        requestPostDTO.setUploadTime(postDAO.getUploadTime());

        // DTO 반환
        return requestPostDTO;
    }
}
