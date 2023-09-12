package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.DiaryDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryRepositoryJPA extends JpaRepository<DiaryDAO, Long> {
    List<DiaryDAO> findByMonth(String month);
}
