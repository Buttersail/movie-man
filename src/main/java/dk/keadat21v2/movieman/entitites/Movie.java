package dk.keadat21v2.movieman.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {


    @Id
    int id;

    String title;
    String overview;
    int runtime;
    String posterPath;
    String releaseDate;
    String status;
    double voteAverage;

    @OneToMany(mappedBy ="genreByMovie", fetch = FetchType.EAGER)
    private Set<MovieGenreList> genres = new HashSet<>();

    @CreationTimestamp
    LocalDateTime created;


    public void addMovieGenreList(MovieGenreList genre){
        genres.add(genre);
    }

    public Movie(int id, String title, String overview, int runtime, String posterPath, String releaseDate, String status, double voteAverage) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.runtime = runtime;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.status = status;
        this.voteAverage = voteAverage;
    }
}
