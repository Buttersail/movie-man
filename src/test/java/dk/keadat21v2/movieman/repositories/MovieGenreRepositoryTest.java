package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.Genre;
import dk.keadat21v2.movieman.entitites.Movie;
import dk.keadat21v2.movieman.entitites.MovieGenreList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieGenreRepositoryTest {

    @Autowired
        MovieGenreRepository movieGenreRepository;
    @Autowired
        MovieRepository movieRepository;
    @Autowired
        GenreRepository genreRepository;

    public Movie m1,m2;
    public Genre g1,g2;

    @BeforeEach
    void setUp() {
        m1 = movieRepository.save(new Movie(1,"Spider-Man: No Way Home","blablabla spiderman blablalba",148,"","17-12-2021","",8.2));
        m2 = movieRepository.save(new Movie(2,"Rød","bla Rød blabla Rød",100,"","10-03-2022","",7.5));

        g1 = genreRepository.save(new Genre(1,"Action"));
        g2 = genreRepository.save(new Genre(2,"Family"));
    }

    @Test
    void testAddGenre(){
        assertEquals(0, movieRepository.getById(1).getGenres().size());

        movieGenreRepository.save(new MovieGenreList(m1,g1));
        movieGenreRepository.save(new MovieGenreList(m1,g2));

        assertEquals(2, movieRepository.getById(1).getGenres().size());

    }

    @Test
    public void testFindById(){

        Movie mTest = movieRepository.findById(m2.getId()).orElse(null);

        assert mTest != null;
        assertEquals(100,mTest.getRuntime());

    }


}