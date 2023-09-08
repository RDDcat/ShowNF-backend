package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ImageDAO;
import com.shownf.reptile.repository.ImageRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SaveImageLocalBean {


    // 이미지 저장
    // (로컬에다가 저장하는거 너 하고싶으면 여기다 만드셈 아니면 빈을 지워줘)
    public void exec(MultipartFile file){

    }
}
