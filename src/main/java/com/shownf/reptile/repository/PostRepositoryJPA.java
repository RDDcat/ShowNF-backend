package com.shownf.reptile.repository;

import com.shownf.reptile.entity.PostDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepositoryJPA extends JpaRepository<PostDAO, Long> {
    Page<PostDAO> findAll(Pageable pageable);
}
