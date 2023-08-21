package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestPostHeartDTO;
import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

@Component
public class CreatePostHeartDAOBean {

    // 좋아요 저장시 DAO 생성
    public PostHeartDAO exec(Long hId, RequestPostHeartDTO requestPostHeartDTO){

        // 게시물 아이디
        Long pId = requestPostHeartDTO.getPId();

        // 유저 아이디
        String uId = requestPostHeartDTO.getUId();

        // DAO 반환
        return new PostHeartDAO(hId, pId, uId);
    }
}
