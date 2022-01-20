package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.request.ProfileRequest;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("v1/leaderboard")
public class LeaderboardController {

    private final LeaderboardFacade leaderboardFacade;

    @GetMapping
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }

    @PostMapping("/addUser")
    public Profile addUser(@RequestBody ProfileRequest profileRequest) {
        return leaderboardFacade.addUser(profileRequest);
    }

    @GetMapping("/{language}")
    public List<ProfileDto> getLeaderboardByLanguage(@PathVariable String language){
        return leaderboardFacade.getLeaderboardByLanguage(language);
    }
}
