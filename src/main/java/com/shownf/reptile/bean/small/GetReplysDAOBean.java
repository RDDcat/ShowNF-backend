package com.shownf.reptile.bean.small;

import com.shownf.reptile.entity.ReplyDAO;
import com.shownf.reptile.repository.ReplyRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetReplysDAOBean {

    ReplyRepositoryJPA replyRepositoryJPA;

    @Autowired
    public GetReplysDAOBean(ReplyRepositoryJPA replyRepositoryJPA) {
        this.replyRepositoryJPA = replyRepositoryJPA;
    }

    // 댓글에 해당하는 대댓글 전체 조회
    public List<ReplyDAO> exec(Long cId){
        return new ArrayList<>(replyRepositoryJPA.findBycId(cId));
    }
}
