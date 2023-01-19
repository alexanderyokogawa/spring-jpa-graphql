package br.com.amaxnetlab.springgraphql.service;

import br.com.amaxnetlab.springgraphql.entity.Post;
import br.com.amaxnetlab.springgraphql.entity.User;
import br.com.amaxnetlab.springgraphql.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService implements Serializable {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    public Post create (String title, String content, String author) {

        User user = userService.findById(author);

        System.out.println("create post");
        System.out.println(user.getName());

        Post post = new Post(
                UUID.randomUUID(),
                title,
                content,
                new Date(),
                user
        );

        return postRepository.save(post);
    }

    public Post findById (String id) {
        Optional<Post> post = postRepository.findById(UUID.fromString(id));

        if(post.isEmpty()){
            throw new RuntimeException("Post not found");
        }

        return post.get();
    }

    public Collection<Post> findAllByAuthorId (String id) {
        Collection<Post> post = postRepository.findAllByAuthorId(UUID.fromString(id));

        if(post.isEmpty()){
            throw new RuntimeException("Post not found");
        }

        return post;
    }
}
