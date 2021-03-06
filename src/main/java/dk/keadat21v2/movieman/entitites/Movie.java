package dk.keadat21v2.movieman.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    @Lob // Overview occasionally contains lots of data, so Lob (-> large Object) was needed
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

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private Set<MovieList_Movie> movieList_movies = new HashSet<>();

    public void addToMovieList_Movies(MovieList_Movie movieList_movie){
        movieList_movies.add(movieList_movie);
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
