package com.shownf.reptile.repository;

import com.shownf.reptile.entity.PostHeartDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHeartRepositoryJPA extends JpaRepository<PostHeartDAO, Long> {
}
