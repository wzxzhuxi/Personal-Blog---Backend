package com.example.allof.Mapping;

import com.example.allof.Pojo.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TextMapping {

    void Submit(Post post);

    void Update(Post post);

    void Delete(Post post);

    List<Post> Select(Post post);
}
