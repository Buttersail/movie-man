package dk.keadat21v2.movieman.repositories;

import dk.keadat21v2.movieman.entitites.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
