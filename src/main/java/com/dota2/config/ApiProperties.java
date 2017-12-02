package com.dota2.config;

/**
 * Created by vladk on 17.06.2017.
 */

public class ApiProperties {

    private String apiKey;
    private String apiKeyParam;
    private String languageParam;

    private final MatchHistory matchHistory = new MatchHistory();
    private final MatchDetails matchDetails = new MatchDetails();
    private final GameItems gameItems = new GameItems();
    private final GameHeroes gameHeroes = new GameHeroes();
    private final LeagueListing leagueListing = new LeagueListing();
    private final LiveLeagueGames liveLeagueGames = new LiveLeagueGames();
    private final MatchHistoryBySeqNum matchHistoryBySeqNum = new MatchHistoryBySeqNum();

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKeyParam() {
        return apiKeyParam;
    }

    public String getLanguageParam() {
        return languageParam;
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

    public GameHeroes getGameHeroes() {return gameHeroes;}

    public LeagueListing getLeagueListing() {
        return leagueListing;
    }

    public LiveLeagueGames getLiveLeagueGames() {
        return liveLeagueGames;
    }

    public MatchHistoryBySeqNum getMatchHistoryBySeqNum() {
        return matchHistoryBySeqNum;
    }

    public class BaseRequestConfig {

        private String url;

        public String getUrl() {
            return url;
        }

        public String getApiKeyParam() {
            return ApiProperties.this.getApiKeyParam();
        }

        public String getApiKey() {
            return ApiProperties.this.getApiKey();
        }

        public String getLanguageParam() {
            return ApiProperties.this.getLanguageParam();
        }
    }

    public class MatchHistory extends BaseRequestConfig {

        private String heroIdParam;
        private String gameModeParam;
        private String skillParam;
        private String minPlayersParam;
        private String accountIdParam;
        private String leagueIdParam;
        private String startAtMatchIdParam;
        private String matchesRequestedParam;
        private String tournamentGamesOnlyParam;

        public String getHeroIdParam() {
            return heroIdParam;
        }

        public String getGameModeParam() {
            return gameModeParam;
        }

        public String getSkillParam() {
            return skillParam;
        }

        public String getMinPlayersParam() {
            return minPlayersParam;
        }

        public String getAccountIdParam() {
            return accountIdParam;
        }

        public String getLeagueIdParam() {
            return leagueIdParam;
        }

        public String getStartAtMatchIdParam() {
            return startAtMatchIdParam;
        }

        public String getMatchesRequestedParam() {
            return matchesRequestedParam;
        }

        public String getTournamentGamesOnlyParam() {
            return tournamentGamesOnlyParam;
        }

    }

    public class MatchDetails extends BaseRequestConfig {
        private String matchIdParam;

        public String getMatchIdParam() {
            return matchIdParam;
        }
    }

    public class GameItems extends BaseRequestConfig {
    }

    public class GameHeroes extends BaseRequestConfig {

        private String itemizedOnlyParam;

        public String getItemizedOnlyParam() {
            return itemizedOnlyParam;
        }
    }

    public class LeagueListing extends BaseRequestConfig {
    }

    public class LiveLeagueGames extends BaseRequestConfig {
    }

    public class MatchHistoryBySeqNum extends BaseRequestConfig {

        private String startAtMatchSeqNumParam;
        private String matchesRequestedParam;

        public String getStartAtMatchSeqNumParam() {
            return startAtMatchSeqNumParam;
        }

        public String getMatchesRequestedParam() {
            return matchesRequestedParam;
        }
    }
}
