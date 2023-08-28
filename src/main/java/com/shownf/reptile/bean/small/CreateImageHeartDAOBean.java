package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestImageHeartSaveDTO;
import com.shownf.reptile.entity.ImageHeartDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateImageHeartDAOBean {

    // 이미지 좋아요 저장시 DAO 생성
    public ImageHeartDAO exec(Long iHId, RequestImageHeartSaveDTO requestImageHeartSaveDTO){

        // 이미지 아이디
        Long iId = requestImageHeartSaveDTO.getIId();

        // 유저 아이디
        String uId = requestImageHeartSaveDTO.getUId();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // DAO 반환
        return new ImageHeartDAO(iHId, iId, uId, uploadTime);
    }
}
