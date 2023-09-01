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
public class ReplyDAO {
    @Id
    Long replyId;
    Long commentId;
    String userId;
    String content;
    LocalDateTime uploadTime;
    Integer heartCount;
}
