package com.example.allof.Controller;

import com.example.allof.Pojo.Comment;
import com.example.allof.Pojo.Result;
import com.example.allof.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/submit")
    public Result submit(@RequestBody Comment comment){
        commentService.Submit(comment);
        return Result.success("发布成功");
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Comment comment){
        commentService.Delete(comment);
        return Result.success("删除成功");
    }
}
