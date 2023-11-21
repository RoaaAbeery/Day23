package com.example.newsarticle.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotNull(message ="Id should be not null")
    private String id;
    @NotNull(message ="Title should be not null")
    @Size(max =100,message = "The title must be less than 100")
    private String title;
    @NotNull(message ="Author should be not null")
    @Size(min = 4,max =20,message ="The author must be more than 4 characters and maximum length of 20 characters. ")
    private String author;
    @NotNull(message ="Content should be not null")
    @Size(min = 200,message = "The content must be less than 100")
    private String content;
    @NotNull(message ="category should be not null")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "Invalid status value. Must be politics,sports, or technology.")
    private String category;
    @NotNull(message ="imageUrl should be not null")
    private String imageUrl;
    @AssertFalse
    private boolean isPublished;
    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
}
