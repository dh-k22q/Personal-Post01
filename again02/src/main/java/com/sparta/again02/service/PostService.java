package com.sparta.again02.service;

import com.sparta.again02.domain.Post;
import com.sparta.again02.dto.PostDetailDto;
import com.sparta.again02.dto.PostListDto;
import com.sparta.again02.dto.PostRequestDto;
import com.sparta.again02.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    //기능들
    // 업데이트 전체조회 게시물조회 비밀번호확인
    private final PostRepository postRepository;
    //업데이트
    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );
        post.update(requestDto);
        return id;
    }
    //전체게시판조회
    @Transactional
    public List<PostListDto> searchAllDesc(){
        return postRepository.findAllByOrderByModifiedAtDesc().stream()
                .map(PostListDto::new)
                .collect(Collectors.toList());
    }


    //게시판조회
    @Transactional
    public PostDetailDto searchById(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );
        return new PostDetailDto(post);
    }
    //비번확인
    @Transactional
    public String passwordCheck(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 없습니다.")
        );

        return post.getPassword();
    }

}
