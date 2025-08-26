package kz.bitlab.trello1.repository;

import kz.bitlab.trello1.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles"})
    @Query("select u from User u where u.username=:username")
    Optional <User> findByUsernameWithRoles(String username);

    Optional <User> findByUsername(String username);
}
