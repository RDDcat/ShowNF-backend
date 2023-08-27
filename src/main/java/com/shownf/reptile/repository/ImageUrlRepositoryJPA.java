package com.shownf.reptile.repository;

import com.shownf.reptile.entity.ImageUrlDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageUrlRepositoryJPA extends JpaRepository<ImageUrlDAO, Long> {
}
