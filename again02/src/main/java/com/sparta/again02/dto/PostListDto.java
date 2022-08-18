package com.sparta.again02.dto;

import com.sparta.again02.domain.Post;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class PostListDto {
    private Long id;
    private String title;
    private String name;
    private LocalDateTime starDate;
    private LocalDateTime modifiedAt;

    public PostListDto(Post post){
        this.id=post.getId();
        this.title=post.getTitle();
        this.name=post.getName();
        this.starDate=post.getStarDate();
        this.modifiedAt=post.getModifiedAt();
    }

}
