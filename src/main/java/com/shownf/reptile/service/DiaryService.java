package com.shownf.reptile.service;

import com.shownf.reptile.Model.DTO.RequestDiaryDTO;
import com.shownf.reptile.Model.DTO.RequestDiarySaveDTO;
import com.shownf.reptile.Model.DTO.ResponseDiarysDTO;
import com.shownf.reptile.bean.GetDiaryBean;
import com.shownf.reptile.bean.GetDiarysBean;
import com.shownf.reptile.bean.SaveDiaryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    GetDiaryBean getDiaryBean;
    GetDiarysBean getDiarysBean;
    SaveDiaryBean saveDiaryBean;

    @Autowired
    public DiaryService(GetDiaryBean getDiaryBean, GetDiarysBean getDiarysBean, SaveDiaryBean saveDiaryBean) {
        this.getDiaryBean = getDiaryBean;
        this.getDiarysBean = getDiarysBean;
        this.saveDiaryBean = saveDiaryBean;
    }

    // 다이어리 조회
    public RequestDiaryDTO getDiary(Long diaryId){
        return getDiaryBean.exec(diaryId);
    }

    // 다이어리 월별로 조회
    public List<ResponseDiarysDTO> getDiarys(String date){
        return getDiarysBean.exec(date);
    }

    // 다이어리 저장
    public Long saveDiary(RequestDiarySaveDTO requestDiarySaveDTO){
        return saveDiaryBean.exec(requestDiarySaveDTO);
    }
}
