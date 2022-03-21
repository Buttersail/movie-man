package dk.keadat21v2.movieman.controller;

import dk.keadat21v2.movieman.dto.MovieResponse;
import dk.keadat21v2.movieman.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public MovieResponse findMovie(@PathVariable Integer id){
        return movieService.findMovie(id);
    }

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
