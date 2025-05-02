package com.example.hellospringboot.database.seeder;

import com.example.hellospringboot.HelloSpringBootApplication;
import com.example.hellospringboot.model.Comment;
import com.example.hellospringboot.model.Post;
import com.example.hellospringboot.model.User;
import com.example.hellospringboot.repository.CommentRepository;
import com.example.hellospringboot.repository.PostRepository;
import com.example.hellospringboot.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CommentSeeder {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    private final PostRepository postRepository;

    public CommentSeeder(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    public int runSeeder() {
        Faker faker = new Faker();
        Random random = new Random();

        List<User> users = userRepository.findAll();

        List<Post> posts = postRepository.findAll();

        int seededcomments = 0;

        List<Comment> comments = new ArrayList<>();

        for (Post post : posts) {

            int numberOfComments = random.nextInt(4) + 1;

            seededcomments += numberOfComments;

            for (int k = 0; k < numberOfComments; k++) {
                User randomUser = users.get(random.nextInt(users.size())); // Random author
                Comment comment = new Comment(faker.lorem().sentence(), randomUser, post);
                post.addComment(comment);
                comments.add(comment);
            }
        }
//        postRepository.saveAll(posts);
        commentRepository.saveAll(comments);
        System.out.println("Seeded comment " + seededcomments + " for." +posts.size() + " posts");

        return seededcomments;
    }

    public static void main(String[] args) {

        // Initialize Spring Boot and get the application context
        ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);
        // how get current runing app instead of create new app, to avoid conflic port
        // Retrieve the UserPostSeeder bean from the context
        CommentSeeder seeder = context.getBean(CommentSeeder.class);

        // Run the seeder logic
        seeder.runSeeder();

    }

}
