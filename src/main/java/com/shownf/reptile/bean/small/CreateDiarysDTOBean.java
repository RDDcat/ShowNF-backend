package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.ResponseDiarysDTO;
import com.shownf.reptile.Model.entity.DiaryDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateDiarysDTOBean {

    // 월별로 다이어리 조회시 DTO 생성
    public List<ResponseDiarysDTO> exec(List<DiaryDAO> diaryDAOs) {

        List<ResponseDiarysDTO> responseDiarysDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (DiaryDAO diaryDAO : diaryDAOs) {
            ResponseDiarysDTO responseDiarysDTO = new ResponseDiarysDTO();

            responseDiarysDTO.setDiaryId(diaryDAO.getDiaryId());
            responseDiarysDTO.setPetId(diaryDAO.getPetId());
            responseDiarysDTO.setUserId(diaryDAO.getUserId());
            responseDiarysDTO.setDate(diaryDAO.getDate());

            responseDiarysDTOs.add(responseDiarysDTO);
        }

        return responseDiarysDTOs;
    }
}
