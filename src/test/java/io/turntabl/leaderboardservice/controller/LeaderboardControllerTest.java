package io.turntabl.leaderboardservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.turntabl.leaderboardservice.controller.request.ProfileRequest;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileRequestToProfileConverter;
import io.turntabl.leaderboardservice.model.LanguageLevel;
import io.turntabl.leaderboardservice.model.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LeaderboardController.class)
class LeaderboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LeaderboardFacade leaderboardFacade;

    @MockBean
    private ProfileRequest profileRequest;

    @MockBean
    private ProfileRequestToProfileConverter profileRequestToProfileConverter;

    @Test
    void shouldGetLeaderboard() throws Exception {
        ProfileDto profileDto = ProfileDto.builder()
                .username("lameiraatt")
                .name("Ana Lameira")
                .build();
        List<ProfileDto> expectedResponse = List.of(profileDto);

        when(leaderboardFacade.getLeaderboard()).thenReturn(expectedResponse);

        mockMvc.perform(get("/v1/leaderboard"))
                .andExpect(status().isOk())
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    void shouldAddUserToLeaderBoard() throws Exception {
        ProfileDto profileDto = ProfileDto.builder()
                .username("flexninja21")
                .name("Edem Afflu")
                .build();

        Profile profile = new Profile();
        profile.setId(profileDto.getUsername())
                .setClan(profileDto.getClan())
                .setHonour(profileDto.getHonour())
                .setName(profileDto.getName())
                .setOverallRank(profileDto.getOverallRank())
                .setLanguageLevels(List.of(new LanguageLevel().setName("java").setRank(-7)));

        ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.setUsername("flexninja21");

        when(leaderboardFacade.addUser(profileRequest)).thenReturn(profile);

        mockMvc.perform(post("/v1/leaderboard/addUser").content("flexninja21"))
                .andExpect(status().isOk())
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(profile)));
    }
}
