package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestDiarySaveDTO;
import com.shownf.reptile.Model.entity.DiaryDAO;
import com.shownf.reptile.repository.DiaryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveDiaryDAOBean {

    DiaryRepositoryJPA diaryRepositoryJPA;

    @Autowired
    public SaveDiaryDAOBean(DiaryRepositoryJPA diaryRepositoryJPA) {
        this.diaryRepositoryJPA = diaryRepositoryJPA;
    }

    // 다이어리 저장
    public void exec(DiaryDAO diaryDAO){
        diaryRepositoryJPA.save(diaryDAO);
    }

    // 다이어리 저장시 DAO 생성
    public void exec(Long diaryId, RequestDiarySaveDTO requestDiarySaveDTO){

        // 마이펫 아이디
        Long petId = requestDiarySaveDTO.getPetId();

        // 유저 아이디
        String userId = requestDiarySaveDTO.getUserId();

        // 먹이
        String food = requestDiarySaveDTO.getFood();

        // 먹이 수
        Integer foodCounter = requestDiarySaveDTO.getFoodCounter();

        // 먹이 크기
        String size = requestDiarySaveDTO.getSize();

        // 몸무게
        Double weight = requestDiarySaveDTO.getWeight();

        // 메모
        String memo = requestDiarySaveDTO.getMemo();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now();

        // 날짜
        String date = requestDiarySaveDTO.getDate();

        // 년, 월
        String month = date.replaceAll(" ", "").substring(0, 6);

        exec(new DiaryDAO(diaryId, petId, userId, food, foodCounter, size, weight, memo, uploadTime, date, month));
    }
}
