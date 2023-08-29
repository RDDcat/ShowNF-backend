package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestPostHeartSaveDTO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePostHeartDAOBean {

    // 좋아요 저장시 DAO 생성
    public PostHeartDAO exec(Long postHeartId, RequestPostHeartSaveDTO requestPostHeartSaveDTO){

        // 게시물 아이디
        Long postId = requestPostHeartSaveDTO.getPostId();

        // 유저 아이디
        String userId = requestPostHeartSaveDTO.getUserId();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // DAO 반환
        return new PostHeartDAO(postHeartId, postId, userId, uploadTime);
    }
}
