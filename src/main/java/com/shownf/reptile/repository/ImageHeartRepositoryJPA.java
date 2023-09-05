package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.ImageHeartDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageHeartRepositoryJPA extends JpaRepository<ImageHeartDAO, Long> {
    List<ImageHeartDAO> findByUserId(String userId);
}
