package com.shownf.reptile.Model.entity;

import com.shownf.reptile.Model.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDAO {
    @Id
    long postId;
    String userId;
    String title;
    String content;
    Category category;
    LocalDateTime uploadTime;
    Integer heartCount;
    Integer commentCount;
    Integer viewCount;
}
