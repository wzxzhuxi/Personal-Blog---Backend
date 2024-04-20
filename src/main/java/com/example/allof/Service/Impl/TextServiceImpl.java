package com.example.allof.Service.Impl;

import com.example.allof.Mapping.TextMapping;
import com.example.allof.Pojo.Post;
import com.example.allof.Service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextServiceImpl implements TextService {

    @Autowired
    private TextMapping textMapping;

    @Override
    public void Submit(Post post) {
        textMapping.Submit(post);
    }

    @Override
    public void Update(Post post) {
        textMapping.Update(post);
    }

    @Override
    public void Delete(Post post) {
        textMapping.Delete(post);
    }

    @Override
    public List<Post> Select(Post post) {
        return textMapping.Select(post);
    }
}
