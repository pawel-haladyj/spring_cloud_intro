package pl.haladyj.springcloudintro.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRatings {
    private List<Rating> ratings;
}
