package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.DTO.RequestImageDTO;
import com.shownf.reptile.Model.DTO.ResponseImagesDTO;
import com.shownf.reptile.Model.entity.ImageDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateImagesDTOBean {

    // 이미지 조회시 DTO 생성
    public Page<RequestImageDTO> exec(Pageable pageable, Page<ImageDAO> imageDAOs){

        List<RequestImageDTO> requestImageDTOs = new ArrayList<>();

        // DTO 객체에 이미지 정보 넘기기
        for (ImageDAO imageDAO : imageDAOs){
            RequestImageDTO requestImageDTO = new RequestImageDTO();

            requestImageDTO.setImageId(imageDAO.getImageId());
            requestImageDTO.setImageName(imageDAO.getImageName());
            requestImageDTO.setImageUrl(imageDAO.getImageUrl());
            requestImageDTO.setUploadTime(imageDAO.getUploadTime());
            requestImageDTO.setHeartCount(imageDAO.getHeartCount());

            requestImageDTOs.add(requestImageDTO);
        }

        // List 구조를 Page 구조로 변경 후 반환
        return new PageImpl<>(requestImageDTOs, pageable, imageDAOs.getTotalElements());
    }

    // 이미지 아이디로 이미지 조회시 DTO 생성
    public List<ResponseImagesDTO> exec(List<ImageDAO> imageDAOs){

        List<ResponseImagesDTO> responseImagesDTOs = new ArrayList<>();

        // DTO 객체에 게시물 정보 넘기기
        for (ImageDAO imageDAO: imageDAOs) {
            ResponseImagesDTO responseImagesDTO = new ResponseImagesDTO();

            responseImagesDTO.setImageId(imageDAO.getImageId());
            responseImagesDTO.setImageName(imageDAO.getImageName());
            responseImagesDTO.setImageUrl(imageDAO.getImageUrl());
            responseImagesDTO.setUploadTime(imageDAO.getUploadTime());
            responseImagesDTO.setHeartCount(imageDAO.getHeartCount());

            responseImagesDTOs.add(responseImagesDTO);
        }

        // DTO 반환
        return responseImagesDTOs;
    }
}
