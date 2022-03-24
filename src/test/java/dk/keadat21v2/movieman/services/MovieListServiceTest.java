package dk.keadat21v2.movieman.services;

import dk.keadat21v2.movieman.dto.UserRequest;
import dk.keadat21v2.movieman.entitites.MovieList;
import dk.keadat21v2.movieman.entitites.User;
import dk.keadat21v2.movieman.repositories.MovieListRepository;
import dk.keadat21v2.movieman.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class MovieListServiceTest {

    @Autowired
    MovieListRepository movieListRepository;

    @Autowired
    UserRepository userRepository;

    MovieListService movieListService;

    @BeforeAll
    static void beforeAll(@Autowired UserRepository userRepository){
        User user1 = new User(new UserRequest("Mark","kodeord"));
        User user2 = new User(new UserRequest("Kim","koden"));
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @BeforeEach
    void setUp() {
        movieListService = new MovieListService(movieListRepository);

    }

    @Test
    void addMovieList() {
        movieListRepository.save(new MovieList("myList",userRepository.getById("Mark")));

        assertTrue(movieListRepository.count() > 0);
        assertEquals("myList",movieListRepository.getById(1).getName());

    }
}