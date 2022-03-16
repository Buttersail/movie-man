package dk.keadat21v2.movieman.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MovieGenreList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    Movie movieByGenre;

    @ManyToOne
    Genre genreByMovie;

    public MovieGenreList(Movie movieGenre, Genre assignedTo){
        this.movieByGenre = movieGenre;
        this.genreByMovie = assignedTo;
        movieByGenre.addMovieGenreList(this);
        genreByMovie.addMovieGenreList(this);
    }
}
