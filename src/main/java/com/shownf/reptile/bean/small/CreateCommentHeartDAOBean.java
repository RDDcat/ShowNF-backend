package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentHeartSaveDTO;
import com.shownf.reptile.entity.CommentHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateCommentHeartDAOBean {

    // 댓글 좋아요 저장시 DAO 생성
    public CommentHeartDAO exec(Long cHid, RequestCommentHeartSaveDTO requestCommentHeartSaveDTO){

        // 댓글 아이디
        Long cId = requestCommentHeartSaveDTO.getCId();

        // 유저 아이디
        String uId = requestCommentHeartSaveDTO.getUId();

        // DAO 반환
        return new CommentHeartDAO(cHid, cId, uId);
    }
}
