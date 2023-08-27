package com.shownf.reptile.repository;

import com.shownf.reptile.entity.ImageDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositoryJPA extends JpaRepository<ImageDAO, Long> {
}