package com.shownf.reptile.entity;

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
    Long cId;
    Long pId;
    String uId;
    String content;
    LocalDateTime uploadTime;
}