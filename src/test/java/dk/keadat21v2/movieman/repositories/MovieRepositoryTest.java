package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    static Movie m1,m2,m3,m4;

    @BeforeEach
    void setUp() {
        m1 = movieRepository.save(new Movie(1,"Spider-Man: No Way Home","blablabla spiderman blablalba",148,"","17-12-2021","",8.2));
        m2 = movieRepository.save(new Movie(2,"Rød","bla Rød blabla Rød",100,"","10-03-2022","",7.5));
        m3 = movieRepository.save(new Movie(3,"Blacklight","wauw blacklight wuuhhuu",104,"","10-02-2022","",5.6));
        m4 = movieRepository.save(new Movie(4,"The Batman","Dark batman blabla",176,"","03-03-2022","",8.0));
    }

    @Test
    void testCount() {
        movieRepository.save(new Movie(5,"Dark","testzz",104,"","10-02-2022","",5.6));
        assertEquals(5,movieRepository.count());
    }


}