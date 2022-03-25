package dk.keadat21v2.movieman.services;
import dk.keadat21v2.movieman.entitites.Movie;
import dk.keadat21v2.movieman.entitites.MovieList;
import dk.keadat21v2.movieman.entitites.MovieList_Movie;
import dk.keadat21v2.movieman.repositories.MovieListRepository;
import dk.keadat21v2.movieman.repositories.MovieList_MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MovieListService {

    MovieListRepository movieListRepository;
    MovieList_MovieRepository movieList_movieRepository;

    public MovieListService(MovieListRepository movieListRepository, MovieList_MovieRepository movieList_movieRepository){
        this.movieListRepository = movieListRepository;
        this.movieList_movieRepository = movieList_movieRepository;
    }

    /**
     * creates a new movielist for a given user
     * @param body
     * @return
     */
    public MovieList addMovieList(MovieList body) {
        return movieListRepository.save(body);
    }

    /**
     * shows all movieslists for a given user
     * @param username
     * @return
     */
    public List<MovieList> getMovieLists(String username) {
        return movieListRepository.findMovieListsByOwnedBy_Username(username);
    }

    /**
     * adds a movie to a movielist for a given user
     * @param body
     * @return
     */
    public Movie addMovie(MovieList_Movie body) {
        movieList_movieRepository.save(body);
        return body.getMovie();
    }
}
