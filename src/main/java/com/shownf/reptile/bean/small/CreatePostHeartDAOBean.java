package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestPostHeartSaveDTO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePostHeartDAOBean {

    // 좋아요 저장시 DAO 생성
    public PostHeartDAO exec(Long hId, RequestPostHeartSaveDTO requestPostHeartSaveDTO){

        // 게시물 아이디
        Long pId = requestPostHeartSaveDTO.getPId();

        // 유저 아이디
        String uId = requestPostHeartSaveDTO.getUId();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // DAO 반환
        return new PostHeartDAO(hId, pId, uId, uploadTime);
    }
}
