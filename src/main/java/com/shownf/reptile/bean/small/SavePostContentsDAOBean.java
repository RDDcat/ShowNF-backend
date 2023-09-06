package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestPostSaveDTO;
import com.shownf.reptile.Model.entity.PostContentDAO;
import com.shownf.reptile.repository.PostContentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SavePostContentsDAOBean {

    PostContentRepositoryJPA postContentRepositoryJPA;
    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public SavePostContentsDAOBean(PostContentRepositoryJPA postContentRepositoryJPA, CreateUniqueIdBean createUniqueIdBean) {
        this.postContentRepositoryJPA = postContentRepositoryJPA;
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 게시물 내용 저장
    public void exec(List<PostContentDAO> postContentDAOs){
        for (PostContentDAO postContentDAO : postContentDAOs)
            postContentRepositoryJPA.save(postContentDAO);
    }

    // 게시물 저장시 postContent 저장
    public void exec(Long postId, RequestPostSaveDTO requestPostSaveDTO){

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

        exec(postContentDAOs);
    }
}
