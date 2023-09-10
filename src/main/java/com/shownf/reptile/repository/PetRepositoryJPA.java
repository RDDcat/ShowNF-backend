package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.PetDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepositoryJPA extends JpaRepository<PetDAO, Long> {
}
