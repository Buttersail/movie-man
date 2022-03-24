package dk.keadat21v2.movieman.services;
import dk.keadat21v2.movieman.entitites.MovieList;
import dk.keadat21v2.movieman.repositories.MovieListRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieListService {

    MovieListRepository movieListRepository;

    public MovieListService(MovieListRepository movieListRepository){
        this.movieListRepository = movieListRepository;
    }

    public MovieList addMovieList(MovieList body) {
        return movieListRepository.save(body);
    }
}
