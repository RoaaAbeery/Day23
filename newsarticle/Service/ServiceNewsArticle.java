package com.example.newsarticle.Service;

import com.example.newsarticle.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class ServiceNewsArticle {
    ArrayList<NewsArticle> articles=new ArrayList<>();

    public ArrayList<NewsArticle> getArticles(){
        return articles;
    }
    public void addArticles(NewsArticle article){
        articles.add(article);
    }
    public boolean updateArticles(String id,NewsArticle article){
        for (int i = 0; i <articles.size() ; i++) {
            if(articles.get(i).getId().equals(id)){
                articles.set(i,article);
                return true;
            }

        }
        return false;
    }
    public boolean deleteArticles(String id){
        for (int i = 0; i <articles.size() ; i++) {
            if(articles.get(i).getId().equals(id)){
                articles.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<NewsArticle> getcategory(String caterogy){
            ArrayList<NewsArticle> newlist =new ArrayList<>();
            for (NewsArticle newsArticle:articles){
                if (newsArticle.getCategory().equals(caterogy)){
                    newlist.add(newsArticle);
                }
            }
            return newlist;
    }
    public void publish(){
        ArrayList<NewsArticle> newlist1 =new ArrayList<>();
        for (NewsArticle newsArticle:articles){
            newsArticle.setPublished(true);
            newsArticle.setPublishDate(LocalDate.now());
            newlist1.add(newsArticle);
        }
    }
    public ArrayList<NewsArticle> getPuplish(){
        ArrayList<NewsArticle>n=new ArrayList<>();
        for (NewsArticle newsArticle:articles){
            if(newsArticle.isPublished()){
                n.add(newsArticle);
            }
        }
        return n;
    }

}
