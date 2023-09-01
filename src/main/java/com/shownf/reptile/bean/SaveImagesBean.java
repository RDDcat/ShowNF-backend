package com.shownf.reptile.bean;

import com.shownf.reptile.bean.small.CreateImagesDAOBean;
import com.shownf.reptile.bean.small.SaveImagesDAOBean;
import com.shownf.reptile.Model.entity.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class SaveImagesBean {

    CreateImagesDAOBean createImagesDAOBean;
    SaveImagesDAOBean saveImagesDAOBean;

    @Autowired
    public SaveImagesBean(CreateImagesDAOBean createImagesDAOBean, SaveImagesDAOBean saveImagesDAOBean) {
        this.createImagesDAOBean = createImagesDAOBean;
        this.saveImagesDAOBean = saveImagesDAOBean;
    }

    // 이미지 저장
    public void exec(List<MultipartFile> files) throws IOException {

        // 이미지 DAO 저장
        List<ImageDAO> imageDAOs = createImagesDAOBean.exec(files);

        // 이미지 저장
        saveImagesDAOBean.exec(imageDAOs);

    }
}
