package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestReplyHeartSaveDTO;
import com.shownf.reptile.entity.ReplyHeartDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateReplyHeartDAOBean {

    // 대댓글 좋아요 저장시 DAO 생성
    public ReplyHeartDAO exec(Long rHId, RequestReplyHeartSaveDTO requestReplyHeartSaveDTO){

        // 대댓글 아이디
        Long rId = requestReplyHeartSaveDTO.getRId();

        // 유저 아이디
        String uId = requestReplyHeartSaveDTO.getUId();

        // 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        return new ReplyHeartDAO(rHId, rId, uId, uploadTime);
    }
}
