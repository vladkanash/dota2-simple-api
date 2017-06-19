package com.vladkanash.webapi;

import com.vladkanash.config.ApiProperties;
import com.vladkanash.service.WebService;
import org.apache.commons.lang3.Validate;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchHistoryRequest extends ApiRequest {

    private final ApiProperties.MatchHistory config;

    MatchHistoryRequest(ApiProperties apiProperties, WebService webService) {
        super(apiProperties.getMatchHistory().getUrl(), apiProperties, webService);
        this.config = apiProperties.getMatchHistory();
    }

    public MatchHistoryRequest heroId(final long heroId) {
        Validate.isTrue(heroId > 0, "heroId must be positive value");
        this.queryParams.put(config.getHeroIdParam(), heroId);
        return this;
    }

    public MatchHistoryRequest gameMode(final long gameMode) {
        Validate.isTrue(gameMode >= 0 && gameMode <= 16,
                "gameMode value is not valid");
        this.queryParams.put(config.getGameModeParam(), gameMode);
        return this;
    }

    public MatchHistoryRequest skill(final long skill) {
        Validate.isTrue(skill >= 0 && skill <= 3,
                "skill value is not valid");
        this.queryParams.put(config.getSkillParam(), skill);
        return this;
    }

    public MatchHistoryRequest minPlayers(final String minPlayers) {
        Validate.notBlank(minPlayers);
        this.queryParams.put(config.getMinPlayersParam(), minPlayers);
        return this;
    }

    public MatchHistoryRequest accountId(final String accountId) {
        Validate.notBlank(accountId);
        this.queryParams.put(config.getAccountIdParam(), accountId);
        return this;
    }

    public MatchHistoryRequest leagueId(final String leagueId) {
        Validate.notBlank(leagueId);
        this.queryParams.put(config.getLeagueIdParam(), leagueId);
        return this;
    }

    public MatchHistoryRequest startAtMatchId(final String startAtMatchId) {
        Validate.notBlank(startAtMatchId);
        this.queryParams.put(config.getStartAtMatchIdParam(), startAtMatchId);
        return this;
    }

    public MatchHistoryRequest matchesRequested(final String matchesRequested) {
        Validate.notBlank(matchesRequested);
        this.queryParams.put(config.getMatchesRequestedParam(), matchesRequested);
        return this;
    }

    public MatchHistoryRequest tournamentGamesOnly(final boolean tournamentGamesOnly) {
        this.queryParams.put(config.getMatchesRequestedParam(),
                tournamentGamesOnly ? "1" : "0");
        return this;
    }
}
