package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

