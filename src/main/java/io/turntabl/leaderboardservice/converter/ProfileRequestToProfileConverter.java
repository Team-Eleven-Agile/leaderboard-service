package io.turntabl.leaderboardservice.converter;

import io.turntabl.leaderboardservice.controller.request.ProfileRequest;
import io.turntabl.leaderboardservice.model.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfileRequestToProfileConverter implements Converter<ProfileRequest, Profile> {

    @Override
    public Profile convert(ProfileRequest source) {
        Profile profile = new Profile();
        profile.setId(source.getUsername());
        return profile;
    }
}
