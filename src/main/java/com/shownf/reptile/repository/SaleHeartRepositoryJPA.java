package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.SaleHeartDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleHeartRepositoryJPA extends JpaRepository<SaleHeartDAO, Long> {
    List<SaleHeartDAO> findByUserId(String userId);
}
