package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.ResponsePostsDTO;
import com.shownf.reptile.Model.entity.PostDAO;
import com.shownf.reptile.Model.entity.PostHeartDAO;
import com.shownf.reptile.bean.small.CreatePostsDTOBean;
import com.shownf.reptile.bean.small.GetPostHeartsDAOBean;
import com.shownf.reptile.bean.small.GetPostHeartsPostIdBean;
import com.shownf.reptile.bean.small.GetPostsDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserPostHeartsBean {

    GetPostHeartsDAOBean getPostHeartsDAOBean;
    GetPostHeartsPostIdBean getPostHeartsPostIdBean;
    GetPostsDAOBean getPostsDAOBean;
    CreatePostsDTOBean createPostsDTOBean;

    @Autowired
    public GetUserPostHeartsBean(GetPostHeartsDAOBean getPostHeartsDAOBean, GetPostHeartsPostIdBean getPostHeartsPostIdBean, GetPostsDAOBean getPostsDAOBean, CreatePostsDTOBean createPostsDTOBean) {
        this.getPostHeartsDAOBean = getPostHeartsDAOBean;
        this.getPostHeartsPostIdBean = getPostHeartsPostIdBean;
        this.getPostsDAOBean = getPostsDAOBean;
        this.createPostsDTOBean = createPostsDTOBean;
    }

    // 유저가 좋아요한 게시물 조회
    public List<ResponsePostsDTO> exec(String userId){

        // 유저 아이디를 통해 게시물 좋아요 객체 찾기
        List<PostHeartDAO> postHeartDAOs = getPostHeartsDAOBean.exec(userId);

        // 좋아요 객체에서 게시물 아이디 찾기
        List<Long> postIds = getPostHeartsPostIdBean.exec(postHeartDAOs);

        // 게시물 아이디로 게시물 찾기
        List<PostDAO> postDAOs = getPostsDAOBean.exec(postIds);

        // DAO 객체 DTO로 반환
        return createPostsDTOBean.exec(postDAOs);
    }
}
