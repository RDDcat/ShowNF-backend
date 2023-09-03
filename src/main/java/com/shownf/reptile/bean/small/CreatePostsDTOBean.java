package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPostDTO;
import com.shownf.reptile.Model.entity.PostDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePostsDTOBean {

    // 게시물 조회시 DTO 생성
    public Page<RequestPostDTO> exec(Pageable pageable, Page<PostDAO> postDAOs){

        List<RequestPostDTO> requestPostDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (PostDAO postDAO: postDAOs) {
            RequestPostDTO requestPostDTO = new RequestPostDTO();

            // 좋아요 순으로 조회함에 따라 좋아요가 없으면 조회X
            if (postDAO.getHeartCount() <= 0)
                continue;

            requestPostDTO.setPostId(postDAO.getPostId());
            requestPostDTO.setUserId(postDAO.getUserId());
            requestPostDTO.setTitle(postDAO.getTitle());
            requestPostDTO.setContent(postDAO.getContent());
            requestPostDTO.setCategory(postDAO.getCategory().name());
            requestPostDTO.setUploadTime(postDAO.getUploadTime());
            requestPostDTO.setHeartCount(postDAO.getHeartCount());
            requestPostDTO.setCommentCount(postDAO.getCommentCount());
            requestPostDTO.setViewCount(postDAO.getViewCount());

            requestPostDTOs.add(requestPostDTO);
        }

        // List 구조를 Page 구조로 변경 후 반환
        return new PageImpl<>(requestPostDTOs, pageable, postDAOs.getTotalElements());
    }

    // 카테고리별 게시물 조회시 DTO 생성
    public Page<RequestPostDTO> exec(String category, Pageable pageable, Page<PostDAO> postDAOs){

        List<RequestPostDTO> requestPostDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (PostDAO postDAO: postDAOs) {
            RequestPostDTO requestPostDTO = new RequestPostDTO();

            requestPostDTO.setPostId(postDAO.getPostId());
            requestPostDTO.setUserId(postDAO.getUserId());
            requestPostDTO.setTitle(postDAO.getTitle());
            requestPostDTO.setContent(postDAO.getContent());
            requestPostDTO.setCategory(postDAO.getCategory().name());
            requestPostDTO.setUploadTime(postDAO.getUploadTime());
            requestPostDTO.setHeartCount(postDAO.getHeartCount());
            requestPostDTO.setCommentCount(postDAO.getCommentCount());
            requestPostDTO.setViewCount(postDAO.getViewCount());

            requestPostDTOs.add(requestPostDTO);
        }

        // List 구조를 Page 구조로 변경 후 반환
        return new PageImpl<>(requestPostDTOs, pageable, postDAOs.getTotalElements());
    }
}
