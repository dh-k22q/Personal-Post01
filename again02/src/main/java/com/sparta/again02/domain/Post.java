package com.sparta.again02.domain;

import com.sparta.again02.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    //기본거 저장할거 업데이트할거
    public Post(String title,String contents, String password, String name){
        this.title=title;
        this.contents=contents;
        this.password=password;
        this.name=name;
    }

    public Post(PostRequestDto requestDto){
        this.title=requestDto.getTitle();
        this.contents=requestDto.getContents();
        this.password=requestDto.getPassword();
        this.name=requestDto.getName();
    }

    public void update(PostRequestDto requestDto){
        this.title=requestDto.getTitle();
        this.contents=requestDto.getContents();
        this.password=requestDto.getPassword();
        this.name=requestDto.getName();
    }


}
