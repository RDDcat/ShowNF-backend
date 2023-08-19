package com.shownf.reptile.repository;

import com.shownf.reptile.entity.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositoryJPA extends JpaRepository<PostDAO, Long> {
}
