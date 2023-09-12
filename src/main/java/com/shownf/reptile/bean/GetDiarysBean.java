package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.ResponseDiarysDTO;
import com.shownf.reptile.Model.entity.DiaryDAO;
import com.shownf.reptile.bean.small.CreateDiarysDTOBean;
import com.shownf.reptile.bean.small.GetDiarysDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDiarysBean {

    GetDiarysDAOBean getDiarysDAOBean;
    CreateDiarysDTOBean createDiarysDTOBean;

    @Autowired
    public GetDiarysBean(GetDiarysDAOBean getDiarysDAOBean, CreateDiarysDTOBean createDiarysDTOBean) {
        this.getDiarysDAOBean = getDiarysDAOBean;
        this.createDiarysDTOBean = createDiarysDTOBean;
    }

    // 다이어리 월별로 조회
    public List<ResponseDiarysDTO> exec(String date){

        // date 월로 바꾸기
        String month = date.replaceAll(" ", "").substring(0,6);

        // 월로 다이어리 객체 찾기
        List<DiaryDAO> diaryDAOs = getDiarysDAOBean.exec(month);

        // DAO 객체 DTO로 반환
        return createDiarysDTOBean.exec(diaryDAOs);
    }
}
