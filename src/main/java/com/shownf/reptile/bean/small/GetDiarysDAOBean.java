package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.DiaryDAO;
import com.shownf.reptile.repository.DiaryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDiarysDAOBean {

    DiaryRepositoryJPA diaryRepositoryJPA;

    @Autowired
    public GetDiarysDAOBean(DiaryRepositoryJPA diaryRepositoryJPA) {
        this.diaryRepositoryJPA = diaryRepositoryJPA;
    }

    // 월별로 다이어리 조회
    public List<DiaryDAO> exec(String month){
        return diaryRepositoryJPA.findByMonth(month);
    }
}
