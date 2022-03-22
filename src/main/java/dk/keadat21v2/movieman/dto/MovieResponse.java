package dk.keadat21v2.movieman.dto;

import dk.keadat21v2.movieman.entitites.Genre;
import dk.keadat21v2.movieman.entitites.Movie;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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

    //TODO genre er et set i movies og en arraylist i Response
    public MovieResponse(Movie movie){
        this.title = movie.getTitle();
        this.overview = movie.getOverview();
        this.runtime = movie.getRuntime();
        this.posterPath = movie.getPosterPath();
        this.releaseDate = movie.getReleaseDate();
        this.status = movie.getStatus();
        this.voteAverage = movie.getVoteAverage();
        //this.genres = movie.getGenres().toArray();
    }
}
