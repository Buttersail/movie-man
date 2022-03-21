package dk.keadat21v2.movieman.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import dk.keadat21v2.movieman.dto.MovieResponse;
import dk.keadat21v2.movieman.entitites.Movie;
import dk.keadat21v2.movieman.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

@Service
public class MovieService {
    MovieRepository movieRepository;

    MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public MovieResponse fetchMovie(Integer movieId){
        if (movieRepository.existsById(movieId)){
                return new MovieResponse(movieRepository.getById(movieId));
            }
        else {
            try {
                Fetcher fetcher = new Fetcher("https://api.themoviedb.org/3/movie/" + movieId);
                // call the api
                fetcher.fetch();
                // get the json-data as a map of objects.
                Map<String, Object> map = fetcher.getFetchedMap();
                // convert to java-object by typecasting values into the constructor.
                Movie movie = movieRepository.save(new Movie(
                        (Integer) map.get("id"), (String) map.get("title"), (String) map.get("overview"), (Integer) map.get("runtime"),
                        (String) map.get("poster_path"), (String) map.get("release_date"), (String) map.get("status"), (Double) map.get("vote_average")
                ));
                return new MovieResponse((movie));
            } catch(URISyntaxException| JsonProcessingException err) {
                System.out.println("Fetch failed due to: " + err);
                //TODO throw Error400Exeption
            }
        }
        return null; //TODO When error400 is implemented remove this
    }

    /*
    public Set<Movie> searchMovie(String query, int pageNumber){
        try{
            Fetcher fetcher = new Fetcher("https://api.themoviedb.org/3/search/movie?" +
                    "language=en-US&query=" + query + "&page=" + pageNumber + "&include_adult=false");

            fetcher.fetch();

        }
    }

     */
}
