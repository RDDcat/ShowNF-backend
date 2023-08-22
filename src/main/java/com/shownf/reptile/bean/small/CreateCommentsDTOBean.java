package com.shownf.reptile.bean.small;

import com.shownf.reptile.DTO.RequestCommentsDTO;
import com.shownf.reptile.entity.CommentDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateCommentsDTOBean {

    // 댓글 조회시 DTO 생성
    public List<RequestCommentsDTO> exec(List<CommentDAO> commentDAOs){

        List<RequestCommentsDTO> requestCommentsDTOs = new ArrayList<>();

        // DTO 객체에 댓글 정보 넘기기
        for (CommentDAO commentDAO: commentDAOs) {
            RequestCommentsDTO requestCommentsDTO = new RequestCommentsDTO();

            requestCommentsDTO.setCId(commentDAO.getCId());
            requestCommentsDTO.setPId(commentDAO.getPId());
            requestCommentsDTO.setUId(commentDAO.getUId());
            requestCommentsDTO.setContent(commentDAO.getContent());
            requestCommentsDTO.setUploadTime(commentDAO.getUploadTime());
            requestCommentsDTO.setHeartCount(commentDAO.getHeartCount());

            requestCommentsDTOs.add(requestCommentsDTO);
        }

        // DTO 객체들 반환
        return requestCommentsDTOs;
    }
}
