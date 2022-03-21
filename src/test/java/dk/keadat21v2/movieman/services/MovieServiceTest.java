package dk.keadat21v2.movieman.services;

import dk.keadat21v2.movieman.dto.MovieResponse;
import dk.keadat21v2.movieman.entitites.Movie;
import dk.keadat21v2.movieman.repositories.MovieRepository;
import org.hibernate.annotations.Fetch;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

@DataJpaTest
class MovieServiceTest {

    //TODO rewrite with mockito

    @Autowired
    MovieRepository movieRepository;

    MovieService movieService;

    static int mov1Id, mov2Id;

    //@BeforeAll
    static void setup(@Autowired MovieRepository movieRepository){
        movieRepository.deleteAll();
        mov1Id = movieRepository.save(new Movie(1, "test1", "desc1", 90, "path", "date", "released", 7.2)).getId();
        mov2Id = movieRepository.save(new Movie(2, "test2", "desc2", 90, "path", "date", "released", 7.2)).getId();
    }


    //@BeforeEach
    void setupService(){
        movieService = new MovieService(movieRepository);
    }

    //@Test
    void fetchMovie() {
        assertEquals(2,movieRepository.findAll().size());
        MovieResponse response = movieService.findMovie(503);
        System.out.println(response);
        assertNotNull(response);
        assertEquals(3,movieRepository.findAll().size());

        MovieResponse response2 = movieService.findMovie(503);
        System.out.println(response2);
        assertNotNull(response2);
        assertEquals(response,response2);
        assertEquals(3,movieRepository.findAll().size());
    }

    //@Test
    void testExistsByID(){
        assertTrue(movieRepository.existsById(1));
        assertFalse(movieRepository.existsById(4));
    }

    //@Test
    void searchMovie(){
        String response = movieService.searchMovie("house", 1);
        System.out.println(response);
        assertNotNull(response);
    }
}