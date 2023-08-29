package com.shownf.reptile.bean;

import com.shownf.reptile.DTO.RequestCommentsDTO;
import com.shownf.reptile.bean.small.CreateCommentsDTOBean;
import com.shownf.reptile.bean.small.GetCommentsDAOBean;
import com.shownf.reptile.entity.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCommentsBean {

    GetCommentsDAOBean getCommentsDAOBean;
    CreateCommentsDTOBean createCommentsDTOBean;

    @Autowired
    public GetCommentsBean(GetCommentsDAOBean getCommentsDAOBean, CreateCommentsDTOBean createCommentsDTOBean) {
        this.getCommentsDAOBean = getCommentsDAOBean;
        this.createCommentsDTOBean = createCommentsDTOBean;
    }

    // 댓글 전체 조회
    public List<RequestCommentsDTO> exec(Long postId){

        // postId 로 게시물에 해당하는 댓글 찾기
        List<CommentDAO> commentDAOs = getCommentsDAOBean.exec(postId);

        // DAO 객체 DTO 반환
        return createCommentsDTOBean.exec(commentDAOs);
    }
}
