package dk.keadat21v2.movieman.dto;

import dk.keadat21v2.movieman.entitites.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponse {

    String title;
    String overview;
    int runtime;
    String posterPath;
    String releaseDate;
    String status;
    double voteAverage;
    List<Genre> genres = new ArrayList<>();


    // Med Genre
    public MovieResponse(String title, String overview, int runtime, String posterPath, String releaseDate, String status, double voteAverage, List<Genre> genres) {
        this.title = title;
        this.overview = overview;
        this.runtime = runtime;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.status = status;
        this.voteAverage = voteAverage;

        //TODO Finde ud af hvordan det skal fungere?
        this.genres = genres;
    }

    // Uden genre
    public MovieResponse(String title, String overview, int runtime, String posterPath, String releaseDate, String status, double voteAverage) {
        this.title = title;
        this.overview = overview;
        this.runtime = runtime;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.status = status;
        this.voteAverage = voteAverage;
    }
}
