package dk.keadat21v2.movieman.services;

import dk.keadat21v2.movieman.dto.UserRequest;
import dk.keadat21v2.movieman.entitites.Movie;
import dk.keadat21v2.movieman.entitites.MovieList;
import dk.keadat21v2.movieman.entitites.MovieList_Movie;
import dk.keadat21v2.movieman.entitites.User;
import dk.keadat21v2.movieman.repositories.MovieListRepository;
import dk.keadat21v2.movieman.repositories.MovieList_MovieRepository;
import dk.keadat21v2.movieman.repositories.MovieRepository;
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
    MovieList_MovieRepository movieList_movieRepository;

    @Autowired
    MovieRepository movieRepository;

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
    void setUp(@Autowired MovieRepository movieRepository) {
        movieListService = new MovieListService(movieListRepository,movieList_movieRepository);

    }

    @Test
    void addMovieListTest() {
        movieListRepository.save(new MovieList("myList",userRepository.getById("Mark")));

        assertTrue(movieListRepository.count() > 0);
        assertEquals("myList",movieListRepository.getById(1).getName());

    }

    @Test
    void getAllMovieListsFromUserTest(){
        movieListRepository.save(new MovieList("myList1",userRepository.getById("Mark")));
        movieListRepository.save(new MovieList("myList2",userRepository.getById("Mark")));
        movieListRepository.save(new MovieList("myList3",userRepository.getById("Mark")));

        assertEquals(3,movieListRepository.findMovieListsByOwnedBy_Username("Mark").size());

        assertEquals("myList2",movieListRepository.findMovieListsByOwnedBy_Username("Mark").get(1).getName());

    }

    @Test
    void addMovieToListTest(){
        // Arrange
        MovieList movieList1 = movieListRepository.save(new MovieList("myList1",userRepository.getById("Mark")));

        Movie movie1 = new Movie(1,"test movie","blablablabla blablabla ",120,"xxxx","19/3-2022","meh",2.5);
        Movie movie2 = new Movie(2,"test2 movie","xaxaxaxaxaxaaxa",140,"zzzzzz","16/3-2022","muh",5);
        movieRepository.save(movie1);
        movieRepository.save(movie2);


        MovieList_Movie movieToAdd1 = new MovieList_Movie(movieList1,movie1);
        MovieList_Movie movieToAdd2 = new MovieList_Movie(movieList1,movie2);

        //Act

        movieList_movieRepository.save(movieToAdd1);
        movieList_movieRepository.save(movieToAdd2);


        //Assert

        assertEquals(2,movieList_movieRepository.findAll().size());
        assertEquals(2,movieList_movieRepository.findMovieList_MoviesByMovieList_Name("myList1").size());

    }
}