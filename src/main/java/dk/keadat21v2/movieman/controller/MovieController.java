package dk.keadat21v2.movieman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    //TODO autowire når movieservice er oprettet:
    /*
    MovieService movieService;
    public movieController(MovieService movieService){
        this.movieService = movieService;
    }

     */


    //TODO henter movies ud som MovieResponses genereret af movieService (skal det være alle movies, eller skal det bare være et udvalg af 10 f.eks?)
    /*
    @GetMapping
    public List<MovieRespons> getMovies(){
        return movieService.getAllMovies();
    }

     */
    /*
    @GetMapping("/{title}")
    public MovieRespons findMovie(@PathVariable String title){
        return movieService.findMovie(title);
    }

     */
}
