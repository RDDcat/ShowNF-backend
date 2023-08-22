package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentSaveDTO;
import com.shownf.reptile.entity.CommentDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateCommentDAOBean {

    // 댓글 저장시 DAO 생성
    public CommentDAO exec(Long cId, RequestCommentSaveDTO requestCommentSaveDTO){

        // 게시물 아이디
        Long pId = requestCommentSaveDTO.getPId();

        // 유저 아이디
        String uId = requestCommentSaveDTO.getUId();

        // 내용
        String content = requestCommentSaveDTO.getContent();

        // 시간
        LocalDateTime localDateTime = LocalDateTime.now();

        // 좋아요 갯수
        Integer heartCount = 0;

        // 대댓글 갯수
        Integer replyCount = 0;

        return  new CommentDAO(cId, pId, uId, content, localDateTime, heartCount, replyCount);
    }
}
