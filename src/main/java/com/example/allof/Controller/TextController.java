package com.example.allof.Controller;

import com.example.allof.Pojo.Post;
import com.example.allof.Pojo.Result;
import com.example.allof.Service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/text")
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping("/select")
    public Result select(@RequestBody(required = false) Post post){
        List<Post> p=textService.Select(post);
        System.out.println(p);
        return Result.success(p);
    }

    @PostMapping("submit")
    public Result submit(@RequestBody Post post){
        textService.Submit(post);
        return Result.success("提交成功");
    }

    @PutMapping("/update")
    public Result update(@RequestBody Post post){
        textService.Update(post);
        return Result.success("更新成功");
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Post post){
        textService.Delete(post);
        return Result.success("删除成功");
    }
}
