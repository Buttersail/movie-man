package dk.keadat21v2.movieman.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter @Setter
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    private User ownedBy;

    @OneToMany(
            mappedBy = "movieList",
            fetch = FetchType.EAGER
    )
    Set<MovieList_Movie> movieListMovies;

    public void addToMovielist_Movie(MovieList_Movie movieList){
        movieListMovies.add(movieList);
    }

    MovieList(String name, User user){
        this.name = name;
        this.ownedBy = user;
        ownedBy.addMovieList(this);
    }
}
