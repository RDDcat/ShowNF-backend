package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestDiarySaveDTO;
import com.shownf.reptile.bean.SaveDiaryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    SaveDiaryBean saveDiaryBean;

    @Autowired
    public DiaryService(SaveDiaryBean saveDiaryBean) {
        this.saveDiaryBean = saveDiaryBean;
    }

    // 다이어리 저장
    public Long saveDiary(RequestDiarySaveDTO requestDiarySaveDTO){
        return saveDiaryBean.exec(requestDiarySaveDTO);
    }
}
