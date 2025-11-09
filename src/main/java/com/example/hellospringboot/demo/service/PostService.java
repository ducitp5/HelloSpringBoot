package com.example.hellospringboot.demo.service;

import com.example.hellospringboot.demo.dto.PostDTO;
import com.example.hellospringboot.demo.dto.ProfileBasicDTO;
import com.example.hellospringboot.demo.entity.Post;
import com.example.hellospringboot.demo.mapper.PostMapper;
import com.example.hellospringboot.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}