package com.shownf.reptile.bean.small;

import com.shownf.reptile.Model.entity.ImageHeartDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetImageHeartsImageIdBean {

    // 이미지 좋아요에서 이미지 아이디 가져오기
    public List<Long> exec(List<ImageHeartDAO> imageHeartDAOs){

        List<Long> userIds = new ArrayList<>();

        for (ImageHeartDAO imageHeartDAO : imageHeartDAOs)
            userIds.add(imageHeartDAO.getImageId());

        return userIds;
    }
}
