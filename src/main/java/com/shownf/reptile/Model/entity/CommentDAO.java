package com.shownf.reptile.Model.entity;

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
public class CommentDAO {
    @Id
    Long commentId;
    Long postId;
    String userId;
    String content;
    LocalDateTime uploadTime;
    Integer heartCount;
    Integer replyCount;
}
