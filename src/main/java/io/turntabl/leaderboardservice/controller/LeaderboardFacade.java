package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.request.ProfileRequest;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileRequestToProfileConverter;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Component
public class LeaderboardFacade {
    private final LeaderboardRepositoryService leaderboardRepositoryService;
    private final ProfileToProfileDtoConverter profileToProfileDtoConverter;
    private final ProfileRequestToProfileConverter profileRequestToProfileConverter;

    public List<ProfileDto> getLeaderboard() {
        return leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }

    public Profile addUser(ProfileRequest profileRequest) {
        return leaderboardRepositoryService.save(profileRequestToProfileConverter.convert(profileRequest));
    }
}
