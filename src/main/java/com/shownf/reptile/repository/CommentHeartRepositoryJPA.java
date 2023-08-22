package com.shownf.reptile.repository;

import com.shownf.reptile.entity.CommentHeartDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentHeartRepositoryJPA extends JpaRepository<CommentHeartDAO, Long> {
}
