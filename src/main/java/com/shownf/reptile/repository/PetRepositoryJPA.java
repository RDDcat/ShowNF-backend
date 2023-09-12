package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.PetDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepositoryJPA extends JpaRepository<PetDAO, Long> {

    Page<PetDAO> findByUserId(String userId, Pageable pageable);
}
