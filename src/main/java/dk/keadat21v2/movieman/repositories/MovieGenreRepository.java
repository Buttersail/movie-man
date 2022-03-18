package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.MovieGenreList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepository extends JpaRepository<MovieGenreList,Integer> {
}
