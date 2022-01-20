package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.model.LanguageLevel;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LeaderboardFacadeTest {

    @Mock
    private LeaderboardFacade leaderboardFacade;

    @Test
    void getLeaderboardTest() {

        ProfileDto profileDto=ProfileDto.builder()
                .username("Phinehas")
                .name("Phinehas Anteh")
                .build();

        ProfileDto profileDto2=ProfileDto.builder()
                .username("lameiraatt")
                .name("Ana Lameira")
                .build();

        List<ProfileDto> expectedResponse = List.of(profileDto,profileDto2);

        when(leaderboardFacade.getLeaderboard()).thenReturn(List.of(profileDto,profileDto2));
        Assertions.assertEquals(expectedResponse,leaderboardFacade.getLeaderboard());


    }

    @Test
    void getLeaderboardByLanguageTest(){
        ProfileDto profileDto=ProfileDto.builder()
                .username("Phinehas")
                .name("Phinehas Anteh")
                .build();

        List<ProfileDto> expectedResponse = List.of(profileDto);

        when(leaderboardFacade.getLeaderboardByLanguage("java")).thenReturn(List.of(profileDto));
        Assertions.assertEquals(expectedResponse,leaderboardFacade.getLeaderboardByLanguage("java"));

    }

}

