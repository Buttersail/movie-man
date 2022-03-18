package dk.keadat21v2.movieman.services;

import dk.keadat21v2.movieman.dto.MovieResponse;
import dk.keadat21v2.movieman.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieServiceTest {

    //TODO rewrite with mockito

    static MovieService movieService;

    //@BeforeAll
    static void setup(@Autowired MovieRepository movieRepository){
        movieService = new MovieService(movieRepository);
    }

    //@Test
    void fetchMovie() {
        MovieResponse response = movieService.fetchMovie(503);
        System.out.println(response);
        assertNotNull(response);
    }
}