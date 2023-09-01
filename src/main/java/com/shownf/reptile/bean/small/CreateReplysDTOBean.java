package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestReplysDTO;
import com.shownf.reptile.Model.entity.ReplyDAO;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Builder
public class CreateReplysDTOBean {

    // 대댓글 조회시 DTO 생성
    public List<RequestReplysDTO> exec(List<ReplyDAO> replyDAOs){

        List<RequestReplysDTO> requestReplysDTOs = new ArrayList<>();

        // DTO 객체 대댓글 정보 넘기기
        for (ReplyDAO replyDAO : replyDAOs){
            RequestReplysDTO requestReplysDTO = new RequestReplysDTO();

            requestReplysDTO.setReplyId(replyDAO.getReplyId());
            requestReplysDTO.setCommentId(replyDAO.getCommentId());
            requestReplysDTO.setUserId(replyDAO.getUserId());
            requestReplysDTO.setContent(replyDAO.getContent());
            requestReplysDTO.setUploadTime(replyDAO.getUploadTime());
            requestReplysDTO.setHeartCount(replyDAO.getHeartCount());

            requestReplysDTOs.add(requestReplysDTO);
        }

        // DTO 객체 반환
        return requestReplysDTOs;
    }
}
