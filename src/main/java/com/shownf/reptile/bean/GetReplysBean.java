package com.shownf.reptile.bean;

import com.shownf.reptile.Model.DTO.RequestReplysDTO;
import com.shownf.reptile.bean.small.CreateReplysDTOBean;
import com.shownf.reptile.bean.small.GetReplysDAOBean;
import com.shownf.reptile.Model.entity.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetReplysBean {

    GetReplysDAOBean getReplysDAOBean;
    CreateReplysDTOBean createReplysDTOBean;

    @Autowired
    public GetReplysBean(GetReplysDAOBean getReplysDAOBean, CreateReplysDTOBean createReplysDTOBean) {
        this.getReplysDAOBean = getReplysDAOBean;
        this.createReplysDTOBean = createReplysDTOBean;
    }

    // 댓글에 해당하는 대댓글 전부 조회
    public List<RequestReplysDTO> exec(Long commentId){

        // cId로 게시물에 해당하는 댓글 찾기
        List<ReplyDAO> replyDAOs = getReplysDAOBean.exec(commentId);

        // DAO 객체 DTO 반환
        return createReplysDTOBean.exec(replyDAOs);
    }
}
