package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.MovieList_Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieList_MovieRepository extends JpaRepository<MovieList_Movie,Integer> {
    List<MovieList_Movie> findMovieList_MoviesByMovieList_Name(String name);
}
