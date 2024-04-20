package com.example.allof.Pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {

    private Integer post_id;

    private String title;

    private String content;

    private String description;

    private LocalDateTime publish_date=LocalDateTime.now();

    private Integer author_id;

    private Integer category_id;
}
