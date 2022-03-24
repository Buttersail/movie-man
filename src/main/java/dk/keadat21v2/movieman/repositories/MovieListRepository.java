package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListRepository extends JpaRepository<MovieList,Integer> {
}
