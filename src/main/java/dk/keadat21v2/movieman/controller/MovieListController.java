package dk.keadat21v2.movieman.controller;
import dk.keadat21v2.movieman.entitites.MovieList;
import dk.keadat21v2.movieman.services.MovieListService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movielists")
public class MovieListController {

    MovieListService movieListService;

    public MovieListController(MovieListService movieListService){
        this.movieListService = movieListService;
    }
    /*
     add movie to List
     Post Mapping

     */

    /**
     * add a new MovieList
     */
    @PostMapping
    public MovieList createMovieList(@RequestBody MovieList body){
    return movieListService.addMovieList(body);
    }

    /*
    Show all movie lists for a user
    Get Mapping
     */


    /*
    show movies from one list
    Get Mapping
     */


    /*
    Delete movies from list
    Delete Mapping

     */
}
