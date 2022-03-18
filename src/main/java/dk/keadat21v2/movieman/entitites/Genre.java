package dk.keadat21v2.movieman.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Genre {

    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    @Id
    int id;

    String genre;

    @OneToMany(mappedBy = "movieByGenre")
    private Set<MovieGenreList> movies = new HashSet<>();

    public void addMovieGenreList(MovieGenreList movieGenreList) {
        movies.add(movieGenreList);
    }
}
