package com.example.allof.Mapping;

import com.example.allof.Pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapping {
    
    void Submit(Comment comment);

    void Delete(Comment comment);
}
