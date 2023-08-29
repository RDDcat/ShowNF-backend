package com.shownf.reptile.repository;

import com.shownf.reptile.entity.ReplyDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepositoryJPA extends JpaRepository<ReplyDAO, Long> {
    List<ReplyDAO> findByCommentId(Long commentId);
}
