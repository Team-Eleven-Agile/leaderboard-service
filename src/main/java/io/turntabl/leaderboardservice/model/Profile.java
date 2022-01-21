package io.turntabl.leaderboardservice.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PROFILES")
@Data
@Accessors(chain = true)
public class Profile {

    @Id
    @ApiModelProperty(notes = "Users Username", name="id", required = true, value = "lameriatt")
    private String id;

    @ApiModelProperty(notes = "Name of User", name="name", required = true, value = "Ana Lameira")
    private String name;

    @ApiModelProperty(notes = "Users clan", name="clan", required = false, value = "turntabl")
    private String clan;

    @ApiModelProperty(notes = "Users accumulated honour ", name="honour", required = true, value = "-7")
    private Integer honour;

    @ApiModelProperty(notes = "Users currnent rank", name="overallRank", required = true, value = "7")
    private Integer overallRank;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LanguageLevel> languageLevels;

    public Profile setLanguageLevels(List<LanguageLevel> languageLevels) {
        for (LanguageLevel languageLevel: languageLevels) {
            languageLevel.setProfile(this);
        }
        this.languageLevels = languageLevels;
        return this;
    }
}
