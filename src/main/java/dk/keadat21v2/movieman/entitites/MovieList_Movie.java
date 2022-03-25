package dk.keadat21v2.movieman.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class MovieList_Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    MovieList movieList;

    @ManyToOne
    Movie movie;

    public MovieList_Movie(MovieList movieList, Movie movie){
        this.movie = movie;
        this.movieList = movieList;
        movie.addToMovieList_Movies(this);
        movieList.addToMovielist_Movie(this);
    }

}

