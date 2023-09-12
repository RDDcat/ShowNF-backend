package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.bean.small.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostBean {

    CreateUniqueIdBean createUniqueIdBean;
    SavePostContentsDAOBean savePostContentsDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SavePostBean(CreateUniqueIdBean createUniqueIdBean, SavePostContentsDAOBean savePostContentsDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.savePostContentsDAOBean = savePostContentsDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    public Long exec(RequestPostSaveDTO requestPostSaveDTO){
        // postId 생성
        long postId = createUniqueIdBean.exec();

        // postContents 저장
        savePostContentsDAOBean.exec(postId, requestPostSaveDTO);

        // 게시물 저장
        savePostDAOBean.exec(postId, requestPostSaveDTO);

        // 게시물 postId 반환
        return postId;
    }
}
