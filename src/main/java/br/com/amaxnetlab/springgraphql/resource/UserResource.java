package br.com.amaxnetlab.springgraphql.resource;

import br.com.amaxnetlab.springgraphql.entity.User;
import br.com.amaxnetlab.springgraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserResource {
    @Autowired
    UserService userService;

    @MutationMapping
    public User createUser (@Argument String name, @Argument String email) {
        return userService.create(name, email);
    }

    @QueryMapping
    public User user (@Argument String id) {
        return userService.findById(id);
    }
}
