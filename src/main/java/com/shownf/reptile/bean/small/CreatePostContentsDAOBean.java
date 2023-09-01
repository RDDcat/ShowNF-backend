package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.Model.entity.PostContentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CreatePostContentsDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreatePostContentsDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 게시물 생성시 postContent 저장
    public List<PostContentDAO> exec(Long postId, RequestPostSaveDTO requestPostSaveDTO){

        // 반환하려는 PostContent List
        List<PostContentDAO> postContentDAOs = new ArrayList<>();

        // 입력받은 postContent 갯수
        List<Map<String, String>> list = requestPostSaveDTO.getContent();
        int count = list.size();

        for (int i = 0; i < count; i++){

            // postContentId 생성
            Long postContentId = createUniqueIdBean.exec();

            // 이미지 Url
            String imageUrl = list.get(i).get("imageUrl");

            // 내용
            String content = list.get(i).get("content");

            postContentDAOs.add(new PostContentDAO(postContentId, postId, imageUrl, content));
        }

        // postContent 반환
        return postContentDAOs;
    }
}
