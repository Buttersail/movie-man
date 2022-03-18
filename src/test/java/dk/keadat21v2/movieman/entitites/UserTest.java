package dk.keadat21v2.movieman.entitites;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserTest {

    static String password;
    static User test;
    static PasswordEncoder pwEncoder;

    @BeforeAll
    static void setup(){
        password = "test1234";
        test = new User("test", password);
        pwEncoder = User.getPasswordEncoder();
    }

    @Test
    void testStaticPwEncoder(){
        assertTrue(pwEncoder.matches(password, test.getPassword()));
        assertFalse(pwEncoder.matches("shouldfail", test.getPassword()));
    }
}