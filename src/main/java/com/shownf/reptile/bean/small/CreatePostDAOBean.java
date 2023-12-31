package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.Model.Enum.Category;
import com.shownf.reptile.Model.entity.PostDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePostDAOBean {

    // 게시물 저장시 DAO 생성
    public PostDAO exec(long postId, RequestPostSaveDTO requestPostSaveDTO){

        // 유저 아이디
        String userId = requestPostSaveDTO.getUserId();

        // 제목
        String title = requestPostSaveDTO.getTitle();

        // 내용
        String content = requestPostSaveDTO.getContent().toString();

        // 카테고리
        Category category = Category.valueOf(requestPostSaveDTO.getCategory());

        // 시간
        LocalDateTime localDateTime = LocalDateTime.now();

        // 게시물 좋아요 갯수
        Integer heartCount = 0;

        // 게시물 댓글 갯수
        Integer commentCount = 0;

        // 조회수
        Integer viewCount = 0;

        // DTO 반환
        return new PostDAO(postId, userId, title, content, category, localDateTime, heartCount, commentCount, viewCount);
    }
}
