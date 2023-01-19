package br.com.amaxnetlab.springgraphql.resource;

import br.com.amaxnetlab.springgraphql.entity.Post;
import br.com.amaxnetlab.springgraphql.entity.User;
import br.com.amaxnetlab.springgraphql.service.PostService;
import br.com.amaxnetlab.springgraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostResource {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;


    @MutationMapping
    public Post createPost (@Argument String title, @Argument String content, @Argument String author) {
        return postService.create(title, content, author);
    }

    @QueryMapping
    public Post post (@Argument String id) {
        return postService.findById(id);
    }

    @SchemaMapping
    public User author (Post post) {
        System.out.println("user");
        System.out.println(post.getAuthor().getId());
        return userService.findById(post.getAuthor().getId().toString());
    }
}
