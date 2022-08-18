package com.sparta.again02.dto;

import com.sparta.again02.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDetailDto {
    private Long id;
    private String title;
    private String name;
    private LocalDateTime starDate;
    private LocalDateTime modifiedAt;
    private String contents;

    public PostDetailDto(Post post){
        this.id= post.getId();
        this.title=post.getTitle();
        this.name=post.getName();
        this.starDate=post.getStarDate();
        this.modifiedAt=post.getModifiedAt();
        this.contents=post.getContents();
    }
}
