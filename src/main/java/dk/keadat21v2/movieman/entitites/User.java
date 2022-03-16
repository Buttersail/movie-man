package dk.keadat21v2.movieman.entitites;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    //Cleartext atm
    //Sizelimit for future encryption with bcrypt
    @Column(nullable = false, length = 72)
    private String password;

    User(String username, String password){
        this.username = username;
        this.password = pwEncoder.encode(password);
    }

    static PasswordEncoder getPasswordEncoder(){
        return pwEncoder;
    }

    public void setPassword(String password) {
        this.password = pwEncoder.encode(password);
    }
}
