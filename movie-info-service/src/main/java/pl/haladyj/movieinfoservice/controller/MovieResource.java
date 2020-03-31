package pl.haladyj.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.haladyj.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){
        return new Movie(movieId,"Test name");
    }
}
