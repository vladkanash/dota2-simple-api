package com.vladkanash.config;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by vladk on 17.06.2017.
 */

@Configuration
@PropertySource("classpath:config/dota2api.properties")
@ConfigurationProperties(prefix="dota2.api")
public class ApiProperties {

    @NotBlank
    private String key;

    @NotBlank
    private String keyParam;

    private final MatchHistory matchHistory = new MatchHistory();
    private final MatchDetails matchDetails = new MatchDetails();
    private final GameItems gameItems = new GameItems();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyParam() {
        return keyParam;
    }

    public void setKeyParam(String keyParam) {
        this.keyParam = keyParam;
    }

    public MatchHistory getMatchHistory() {
        return matchHistory;
    }

    public MatchDetails getMatchDetails() {
        return matchDetails;
    }

    public GameItems getGameItems() {
        return gameItems;
    }

    public static class MatchHistory {

        private String url;
        private String heroIdParam;
        private String gameModeParam;
        private String skillParam;
        private String minPlayersParam;
        private String accountIdParam;
        private String leagueIdParam;
        private String startAtMatchIdParam;
        private String matchesRequestedParam;
        private String tournamentGamesOnlyParam;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHeroIdParam() {
            return heroIdParam;
        }

        public void setHeroIdParam(String heroIdParam) {
            this.heroIdParam = heroIdParam;
        }

        public String getGameModeParam() {
            return gameModeParam;
        }

        public void setGameModeParam(String gameModeParam) {
            this.gameModeParam = gameModeParam;
        }

        public String getSkillParam() {
            return skillParam;
        }

        public void setSkillParam(String skillParam) {
            this.skillParam = skillParam;
        }

        public String getMinPlayersParam() {
            return minPlayersParam;
        }

        public void setMinPlayersParam(String minPlayersParam) {
            this.minPlayersParam = minPlayersParam;
        }

        public String getAccountIdParam() {
            return accountIdParam;
        }

        public void setAccountIdParam(String accountIdParam) {
            this.accountIdParam = accountIdParam;
        }

        public String getLeagueIdParam() {
            return leagueIdParam;
        }

        public void setLeagueIdParam(String leagueIdParam) {
            this.leagueIdParam = leagueIdParam;
        }

        public String getStartAtMatchIdParam() {
            return startAtMatchIdParam;
        }

        public void setStartAtMatchIdParam(String startAtMatchIdParam) {
            this.startAtMatchIdParam = startAtMatchIdParam;
        }

        public String getMatchesRequestedParam() {
            return matchesRequestedParam;
        }

        public void setMatchesRequestedParam(String matchesRequestedParam) {
            this.matchesRequestedParam = matchesRequestedParam;
        }

        public String getTournamentGamesOnlyParam() {
            return tournamentGamesOnlyParam;
        }

        public void setTournamentGamesOnlyParam(String tournamentGamesOnlyParam) {
            this.tournamentGamesOnlyParam = tournamentGamesOnlyParam;
        }
    }

    public static class MatchDetails {

        private String url;
        private String matchIdParam;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMatchIdParam() {
            return matchIdParam;
        }

        public void setMatchIdParam(String matchIdParam) {
            this.matchIdParam = matchIdParam;
        }
    }

    public static class GameItems {

        private String url;
        private String languageParam;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLanguageParam() {
            return languageParam;
        }

        public void setLanguageParam(String languageParam) {
            this.languageParam = languageParam;
        }
    }
}
