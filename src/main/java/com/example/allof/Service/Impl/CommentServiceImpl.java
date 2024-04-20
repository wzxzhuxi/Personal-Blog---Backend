package com.example.allof.Service.Impl;

import com.example.allof.Mapping.CommentMapping;
import com.example.allof.Pojo.Comment;
import com.example.allof.Pojo.Post;
import com.example.allof.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapping commentMapping;

    @Override
    public void Submit(Comment comment) {
        commentMapping.Submit(comment);
    }

    @Override
    public void Delete(Comment comment) {
        commentMapping.Delete(comment);
    }
}
