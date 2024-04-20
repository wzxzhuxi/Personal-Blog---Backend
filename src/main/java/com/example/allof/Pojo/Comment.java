package com.example.allof.Pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private Integer comment_id;

    private Integer post_id;

    private String content;

    private String commenter_id;

    private LocalDateTime comment_date=LocalDateTime.now();


}
