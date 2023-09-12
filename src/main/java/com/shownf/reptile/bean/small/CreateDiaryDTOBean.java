package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestDiaryDTO;
import com.shownf.reptile.Model.entity.DiaryDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateDiaryDTOBean {

    // 다이어리 조회시 DTO 생성
    public RequestDiaryDTO exec(DiaryDAO diaryDAO){
        RequestDiaryDTO requestDiaryDTO = new RequestDiaryDTO();

        // DTO 객체에 다이어리 정보 넘기기
        requestDiaryDTO.setDiaryId(diaryDAO.getDiaryId());
        requestDiaryDTO.setPetId(diaryDAO.getPetId());
        requestDiaryDTO.setUserId(diaryDAO.getUserId());
        requestDiaryDTO.setFood(diaryDAO.getFood());
        requestDiaryDTO.setFoodCounter(diaryDAO.getFoodCounter());
        requestDiaryDTO.setSize(diaryDAO.getSize());
        requestDiaryDTO.setWeight(diaryDAO.getWeight());
        requestDiaryDTO.setMemo(diaryDAO.getMemo());
        requestDiaryDTO.setDate(diaryDAO.getDate());
        requestDiaryDTO.setMonth(diaryDAO.getMonth());

        return requestDiaryDTO;
    }
}
