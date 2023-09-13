package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.SaleDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositoryJPA extends JpaRepository<SaleDAO, Long> {
    Page<SaleDAO> findAll(Pageable pageable);
}
