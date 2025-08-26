package kz.bitlab.trello1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Role extends BaseClass implements GrantedAuthority {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;


    @Override
    public String getAuthority() {
        return name;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
//неге бунда коймаймыз еще
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name="user_role",
//            joinColumns = @JoinColumn(name="user_id"),
//            inverseJoinColumns = @JoinColumn(name="role_id"))
//    private Set<Role> roles;
}
