package com.example.allof.Service;

import com.example.allof.Pojo.Post;

import java.util.List;

public interface TextService {

    void Submit(Post post);

    void Update(Post post);

    void Delete(Post post);

    List<Post> Select(Post post);
}
