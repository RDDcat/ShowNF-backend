package com.shownf.reptile.repository;

import com.shownf.reptile.Model.entity.PostContentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostContentRepositoryJPA extends JpaRepository<PostContentDAO, Long> {
}
