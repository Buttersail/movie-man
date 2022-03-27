package dk.keadat21v2.movieman.entitites;

import dk.keadat21v2.movieman.dto.UserRequest;
import lombok.*;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "user")
public class User {

    public static final int USER_NAME_MIN_SIZE = 3;
    public static final int USER_NAME_MAX_SIZE = 20;

    public static final int PASSWORD_MIN_SIZE = 6;
    public static final int PASSWORD_MAX_SIZE = 40;
    static final PasswordEncoder pwEncoder = new BCryptPasswordEncoder();

    @Id
    private String username;

    //Sizelimit for future encryption with bcrypt
    @Column(nullable = false, length = 72)
    private String password;

    @OneToMany(
            mappedBy = "ownedBy",
            fetch = FetchType.EAGER
    )
    private Set<MovieList> movieLists = new HashSet<>();

    public void addMovieList(MovieList movieList){movieLists.add(movieList);}

    User(String username, String password){
        this.username = username;
        this.password = pwEncoder.encode(password);
    }

    public User(UserRequest body) {
        this(body.getUsername(), body.getPassword());
    }

    public static PasswordEncoder getPasswordEncoder(){
        return pwEncoder;
    }

    public void setPassword(String password) {
        this.password = pwEncoder.encode(password);
    }
}
