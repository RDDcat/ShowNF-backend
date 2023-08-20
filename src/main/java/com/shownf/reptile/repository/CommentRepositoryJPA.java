package com.shownf.reptile.repository;

import com.shownf.reptile.entity.CommentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositoryJPA extends JpaRepository<CommentDAO, Long> {
}
