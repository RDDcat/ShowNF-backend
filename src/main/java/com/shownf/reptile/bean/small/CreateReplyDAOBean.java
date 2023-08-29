package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestReplySaveDTO;
import com.shownf.reptile.entity.ReplyDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateReplyDAOBean {

    // 대댓글 저장시 DAO 생성
    public ReplyDAO exec(Long replyId, RequestReplySaveDTO requestReplySaveDTO){

        // 댓글 아이디
        Long commentId = requestReplySaveDTO.getCommentId();

        // 유저 아이디
        String userId = requestReplySaveDTO.getUserId();

        // 내용
        String content = requestReplySaveDTO.getContent();

        // 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // 대댓글 좋아요 갯수
        Integer heartCount = 0;

        // DAO 반환
        return new ReplyDAO(replyId, commentId, userId, content, uploadTime, heartCount);
    }
}
