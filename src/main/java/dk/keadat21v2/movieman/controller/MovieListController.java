package dk.keadat21v2.movieman.controller;
import dk.keadat21v2.movieman.entitites.Movie;
import dk.keadat21v2.movieman.entitites.MovieList;
import dk.keadat21v2.movieman.entitites.MovieList_Movie;
import dk.keadat21v2.movieman.services.MovieListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movielists")
public class MovieListController {

    MovieListService movieListService;

    public MovieListController(MovieListService movieListService){
        this.movieListService = movieListService;
    }


    /**
     add movie to List
     Post Mapping
     */
    @PostMapping("/movielist/")
    public Movie addMovie(@RequestBody MovieList_Movie body){
        return movieListService.addMovie(body);
    }

    /**
     * add a new MovieList
     */
    @PostMapping
    public MovieList createMovieList(@RequestBody MovieList body){
    return movieListService.addMovieList(body);
    }

    /**
    * Show all movie lists for a user
    */
    @GetMapping("/{username}")
    public List<MovieList> userMovieLists(@PathVariable String username){
        return movieListService.getMovieLists(username);
    }

    /*
    show movies from one list
    Get Mapping
     */


    /*
    Delete movies from list
    Delete Mapping

     */
}
