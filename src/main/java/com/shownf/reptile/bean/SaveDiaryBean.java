package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestDiarySaveDTO;
import com.shownf.reptile.bean.small.CreateUniqueIdBean;
import com.shownf.reptile.bean.small.SaveDiaryDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveDiaryBean {

    CreateUniqueIdBean createUniqueIdBean;
    SaveDiaryDAOBean saveDiaryDAOBean;

    @Autowired
    public SaveDiaryBean(CreateUniqueIdBean createUniqueIdBean, SaveDiaryDAOBean saveDiaryDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.saveDiaryDAOBean = saveDiaryDAOBean;
    }

    // 다이어리 저장
    public Long exec(RequestDiarySaveDTO requestDiarySaveDTO){

        // diaryId 생성
        Long diaryId = createUniqueIdBean.exec();

        // 다이어리 저장
        saveDiaryDAOBean.exec(diaryId, requestDiarySaveDTO);

        // 다이어리 diaryId 반환
        return diaryId;
    }
}
