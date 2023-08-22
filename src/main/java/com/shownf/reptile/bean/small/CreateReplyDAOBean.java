package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestReplySaveDTO;
import com.shownf.reptile.entity.ReplyDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateReplyDAOBean {

    // 대댓글 저장시 DAO 생성
    public ReplyDAO exec(Long rId, RequestReplySaveDTO requestReplySaveDTO){

        // 댓글 아이디
        Long cId = requestReplySaveDTO.getCId();

        // 유저 아이디
        String uId = requestReplySaveDTO.getUId();

        // 내용
        String content = requestReplySaveDTO.getContent();

        // 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // DAO 반환
        return new ReplyDAO(rId, cId, uId, content, uploadTime);
    }
}
