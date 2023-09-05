package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.PostHeartDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetPostHeartsPostIdBean {

    // 좋아요 게시물에서 게시물 아이디 가져오기
    public List<Long> exec(List<PostHeartDAO> postHeartDAOs){

        List<Long> postIds = new ArrayList<>();

        for (PostHeartDAO postHeartDAO : postHeartDAOs)
            postIds.add(postHeartDAO.getPostId());

        return postIds;
    }
}
