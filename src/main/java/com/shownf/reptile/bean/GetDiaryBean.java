package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestDiaryDTO;
import com.shownf.reptile.Model.entity.DiaryDAO;
import com.shownf.reptile.bean.small.CreateDiaryDTOBean;
import com.shownf.reptile.bean.small.GetDiaryDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDiaryBean {

    GetDiaryDAOBean getDiaryDAOBean;
    CreateDiaryDTOBean createDiaryDTOBean;

    @Autowired
    public GetDiaryBean(GetDiaryDAOBean getDiaryDAOBean, CreateDiaryDTOBean createDiaryDTOBean) {
        this.getDiaryDAOBean = getDiaryDAOBean;
        this.createDiaryDTOBean = createDiaryDTOBean;
    }

    // 다이어리 조회
    public RequestDiaryDTO exec(Long diaryId){

        // diaryId로 다이어리 찾기
        DiaryDAO diaryDAO = getDiaryDAOBean.exec(diaryId);

        // 다이어리 객체 DTO 변환 후 반환
        return createDiaryDTOBean.exec(diaryDAO);
    }
}
