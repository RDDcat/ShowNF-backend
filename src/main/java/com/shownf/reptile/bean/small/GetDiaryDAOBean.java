package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.DiaryDAO;
import com.shownf.reptile.repository.DiaryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDiaryDAOBean {

    DiaryRepositoryJPA diaryRepositoryJPA;

    @Autowired
    public GetDiaryDAOBean(DiaryRepositoryJPA diaryRepositoryJPA) {
        this.diaryRepositoryJPA = diaryRepositoryJPA;
    }

    // 다이어리 찾기
    public DiaryDAO exec(Long diaryId){
        return diaryRepositoryJPA.findById(diaryId).get();
    }
}
