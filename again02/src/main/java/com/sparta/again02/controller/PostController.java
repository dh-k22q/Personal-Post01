package com.sparta.again02.controller;

import com.sparta.again02.domain.Post;
import com.sparta.again02.dto.PostDetailDto;
import com.sparta.again02.dto.PostListDto;
import com.sparta.again02.dto.PostRequestDto;
import com.sparta.again02.repository.PostRepository;
import com.sparta.again02.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PostController {
    //기능들
    //등록 게시물조회 전체조회 수정 삭제
    private PostRepository postRepository;
    private PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")
    public List<PostListDto> readPost() {
        return postService.searchAllDesc();
    }

    @GetMapping("/api/posts/{id}")
    public PostDetailDto searchById(@PathVariable Long id) {
        return postService.searchById(id);
    }

    @PutMapping("/api/posts/{id}")
    public boolean updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        if (requestDto.getPassword().equals(postService.passwordCheck(id))) {
            postService.update(id, requestDto);
            return true;
        } else {
            System.out.println("비밀번호를 확인해 주세요");
            return false;
        }
    }

    @DeleteMapping("/api/posts/{id}")
    public boolean deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        if (requestDto.getPassword().equals(postService.passwordCheck(id))) {
            postRepository.deleteById(id);
            return true;
        } else {
            System.out.println("비밀번호를 확인해 주세요");
            return false;
        }
    }
}
