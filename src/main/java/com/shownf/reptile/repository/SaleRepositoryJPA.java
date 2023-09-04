package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.SaleDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositoryJPA extends JpaRepository<SaleDAO, Long> {
}
