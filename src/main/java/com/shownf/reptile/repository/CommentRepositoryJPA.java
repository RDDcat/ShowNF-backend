package com.shownf.reptile.repository;

import com.shownf.reptile.entity.CommentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepositoryJPA extends JpaRepository<CommentDAO, Long> {
    List<CommentDAO> findByPostId(Long postId);
}
