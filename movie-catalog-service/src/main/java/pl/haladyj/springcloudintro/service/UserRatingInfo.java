package pl.haladyj.springcloudintro.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pl.haladyj.springcloudintro.model.Rating;
import pl.haladyj.springcloudintro.model.UserRatings;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRatings getUserRating(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId,
                UserRatings.class);
    }

    public UserRatings getFallbackUserRating(@PathVariable("userId") String userId){
        UserRatings userRatings = new UserRatings();
        userRatings.setUserId(userId);
        userRatings.setRatings(Arrays.asList(
                new Rating("0",0)
                )
        );
        return userRatings;
    }


}
