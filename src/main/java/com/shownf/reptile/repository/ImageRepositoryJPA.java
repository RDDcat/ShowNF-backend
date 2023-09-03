package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.ImageDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositoryJPA extends JpaRepository<ImageDAO, Long> {

    Page<ImageDAO> findAll(Pageable pageable);
}