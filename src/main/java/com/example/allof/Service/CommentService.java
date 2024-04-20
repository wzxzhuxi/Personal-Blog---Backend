package com.example.allof.Service;

import com.example.allof.Pojo.Comment;

public interface CommentService {
    void Submit(Comment comment);

    void Delete(Comment comment);
}
