package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.MovieList;
import dk.keadat21v2.movieman.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MovieListRepository extends JpaRepository<MovieList,Integer> {

    List<MovieList> findMovieListsByOwnedBy_Username(String username);


}
