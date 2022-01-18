package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Component
public class LeaderboardFacade {

    private final LeaderboardRepositoryService leaderboardRepositoryService;
    private final ProfileToProfileDtoConverter profileToProfileDtoConverter;

    public List<ProfileDto> getLeaderboard() {
        return leaderboardRepositoryService.getProfiles().stream()
                .sorted(Comparator.comparing(Profile::getHonour).reversed())
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }

    public List<ProfileDto> getLeaderboardByLanguage(String language) {
        return getLeaderboard().stream()
                .filter(profile -> profile.getLanguages().stream()
                        .anyMatch(languageLevel -> languageLevel.getName().equals(language)))
                .collect(toList());
    }
}
