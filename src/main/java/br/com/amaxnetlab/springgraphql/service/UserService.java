package br.com.amaxnetlab.springgraphql.service;

import br.com.amaxnetlab.springgraphql.entity.User;
import br.com.amaxnetlab.springgraphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements Serializable {
    @Autowired
    UserRepository userRepository;

    public User create (String name, String email) {
        System.out.println("create user");
        System.out.println(name);
        System.out.println(email);

        boolean exists = userRepository.existsByEmail(email);

        if (exists) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User(
                UUID.randomUUID(),
                name,
                email,
                null
        );

        return userRepository.save(user);
    }

    public User findById (String id) {
        Optional<User> user = userRepository.findById(UUID.fromString(id));
        if(user.isEmpty()){
            throw new RuntimeException("User not found");
        }
        System.out.println("findById user");
        System.out.println(user.get().getName());
        return user.get();
    }
}
