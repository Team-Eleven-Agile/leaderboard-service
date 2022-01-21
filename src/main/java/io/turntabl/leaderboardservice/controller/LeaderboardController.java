package io.turntabl.leaderboardservice.controller;

import io.swagger.annotations.ApiOperation;
import io.turntabl.leaderboardservice.controller.request.ProfileRequest;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@ApiOperation(value = "v1/leaderboard", tags = "Leaderboard controller")
@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("v1/leaderboard")
public class LeaderboardController {

    private final LeaderboardFacade leaderboardFacade;

    @ApiOperation(value = "view entire leaderboard", response = Iterable.class)
    @GetMapping
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }

    @ApiOperation(value = "add one user to leaderboard view", response = Profile.class)
    @PostMapping("/addUser")
    public Profile addUser(@RequestBody ProfileRequest profileRequest) {
        return leaderboardFacade.addUser(profileRequest);
    }

    @ApiOperation(value = "Filters the leaderboard results by language", response = Iterable.class)
    @GetMapping("/{language}")
    public List<ProfileDto> getLeaderboardByLanguage(@PathVariable String language){
        return leaderboardFacade.getLeaderboardByLanguage(language);
    }
}
