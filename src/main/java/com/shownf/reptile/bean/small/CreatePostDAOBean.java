package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestPostSaveDTO;
import com.shownf.reptile.entity.PostDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePostDAOBean {

    // 게시물 저장시 DAO 생성
    public PostDAO exec(long pId, RequestPostSaveDTO requestPostSaveDTO){

        // 유저 아이디
        String uId = requestPostSaveDTO.getUId();

        // 제목
        String title = requestPostSaveDTO.getTitle();

        // 내용
        String content = requestPostSaveDTO.getContent();

        // 카테고리
        String category = requestPostSaveDTO.getCategory();

        // 시간
        LocalDateTime localDateTime = LocalDateTime.now();

        // 게시물 좋아요 갯수
        Integer heartCount = 0;

        // 게시물 댓글 갯수
        Integer commentCount = 0;

        // DTO 반환
        return new PostDAO(pId, uId, title, content, category, localDateTime, heartCount, commentCount);
    }
}
