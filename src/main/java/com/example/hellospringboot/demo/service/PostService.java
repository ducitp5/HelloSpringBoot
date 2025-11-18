package com.example.hellospringboot.demo.service;

import com.example.hellospringboot.demo.dto.PostClassDTO;
import com.example.hellospringboot.demo.dto.PostDTO;
import com.example.hellospringboot.demo.entity.Post;
import com.example.hellospringboot.demo.mapper.PostMapper;
import com.example.hellospringboot.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("postServiceDemo")
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPostsWithRelations() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostWithRelations(Long id) {
        return postRepository.findByid(id); // This only fetches user, not posts
    }

    public List<PostDTO> getDtoAllPostWithRelations(){
        return postRepository.findAll()
                .stream()
                .map(PostMapper::toBasicDTO)
                .toList();
    }

    public PostDTO getDtoPost(Long id) {
        Post post = postRepository.findById(id).get();;
        return PostMapper.toDTOwithUserId(post);
    }


    public List<PostClassDTO> getDtoClassAllPost() {
        return postRepository.findAll()
                .stream()
                .map(post -> {
                    return PostMapper.toBasicClassDTO(post);
                })
                .toList();
    }

    public PostClassDTO getPostClassDtoWithRelations(Long id) {
        Post post = postRepository.findById(id).get();;
//        return PostMapper.toBasicClassDTO(post);
        return PostMapper.toPostClassDTOwithUserId(post);
    }
}