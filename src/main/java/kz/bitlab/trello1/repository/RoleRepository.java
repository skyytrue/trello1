package kz.bitlab.trello1.repository;

import kz.bitlab.trello1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
        @Query("select r from Role r where r.name='USER_ROLE'")
        Role findRoleUser();
}
