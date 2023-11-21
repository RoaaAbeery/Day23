package com.example.newsarticle.Controller;

import com.example.newsarticle.API.ApiResponse;
import com.example.newsarticle.Model.NewsArticle;
import com.example.newsarticle.Service.ServiceNewsArticle;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api1/v1/article")
@RequiredArgsConstructor
public class NewsArticleController {
private final ServiceNewsArticle newsService;
    @GetMapping("/get")
    public ResponseEntity getArticles(){
            ArrayList<NewsArticle> articles=newsService.getArticles();
            return ResponseEntity.status(HttpStatus.OK).body(articles);
    }
    @PostMapping("/add")
    public ResponseEntity addArticles(@Valid @RequestBody NewsArticle newsArticle, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        newsService.addArticles(newsArticle);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("NewsArticle add"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateArticles(@PathVariable String id ,@Valid@RequestBody NewsArticle newsArticle,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated =newsService.updateArticles(id,newsArticle);
        if(isUpdated){
       return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("News Articles updated"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Id not found"));
    }
    @DeleteMapping("/delete/{id}")
public ResponseEntity deleteArticles(@PathVariable String id){
    boolean isdelete =newsService.deleteArticles(id);
    if(isdelete){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("News Articles deleted"));
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Id not found"));
}
@GetMapping("/Category/{category}")
    public ResponseEntity getcategory (@PathVariable String category){
ArrayList<NewsArticle> n =newsService.getcategory(category);
return ResponseEntity.status(HttpStatus.OK).body(n);
}
    @PutMapping("/publish")
    public ResponseEntity publish(){
        newsService.publish();
        return ResponseEntity.status(HttpStatus.OK).body("is publish");
    }
    @GetMapping("/getpublish")
    public ResponseEntity getpublish(){
        ArrayList get =newsService.getPuplish();
        return ResponseEntity.status(HttpStatus.OK).body(get);
    }
}
