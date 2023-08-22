package com.shownf.reptile.repository;

import com.shownf.reptile.entity.ReplyDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepositoryJPA extends JpaRepository<ReplyDAO, Long> {
}
