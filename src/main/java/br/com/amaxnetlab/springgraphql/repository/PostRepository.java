package br.com.amaxnetlab.springgraphql.repository;

import br.com.amaxnetlab.springgraphql.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    Collection<Post> findAllByAuthorId(UUID id);
}
