package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.CommentHeartDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentHeartRepositoryJPA extends JpaRepository<CommentHeartDAO, Long> {
}
