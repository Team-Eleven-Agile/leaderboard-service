package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LeaderboardFacadeTest {

    @Mock
    private LeaderboardFacade leaderboardFacade;

    @Test
    void getLeaderboard() {
        ProfileDto profileDto = ProfileDto.builder()
                .username("lameiraatt")
                .name("Ana Lameira")
                .build();
        List<ProfileDto> expectedResult = List.of(profileDto);

        when(leaderboardFacade.getLeaderboard())
                .thenReturn(List.of(profileDto));

        assertThat(leaderboardFacade.getLeaderboard()).isEqualTo(expectedResult);

    }

    @Test
    void getLeaderboardByLanguage(){
        ProfileDto profile2 = ProfileDto.builder()
                .username("nana-yaw")
                .name("Edward")
                .build();

        List<ProfileDto> expectedResult = List.of(profile2);

        when(leaderboardFacade.getLeaderboardByLanguage("java")).thenReturn(List.of(profile2));

        assertThat(leaderboardFacade.getLeaderboardByLanguage("java")).isEqualTo(expectedResult);
    }
}
