package pl.haladyj.moviedataservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.haladyj.moviedataservice.model.Rating;
import pl.haladyj.moviedataservice.model.UserRatings;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String usedId){
        List<Rating> ratings =  Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678",3)
        );

        UserRatings userRatings = new UserRatings();
        userRatings.setRatings(ratings);
        return userRatings;
    }
}
