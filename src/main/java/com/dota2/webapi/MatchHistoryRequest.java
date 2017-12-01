package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

import static com.dota2.util.Validation.checkIsTrue;
import static com.dota2.util.Validation.checkNotNull;

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
        checkIsTrue(heroId > 0, "heroId must be positive value");
        this.queryParams.put(config.getHeroIdParam(), heroId);
        return this;
    }

    public MatchHistoryRequest gameMode(final long gameMode) {
        checkIsTrue(gameMode >= 0 && gameMode <= 16,
                "gameMode value is not valid");
        this.queryParams.put(config.getGameModeParam(), gameMode);
        return this;
    }

    public MatchHistoryRequest skill(final long skill) {
        checkIsTrue(skill >= 0 && skill <= 3,
                "skill value is not valid");
        this.queryParams.put(config.getSkillParam(), skill);
        return this;
    }

    public MatchHistoryRequest minPlayers(final String minPlayers) {
        checkNotNull(minPlayers);
        this.queryParams.put(config.getMinPlayersParam(), minPlayers);
        return this;
    }

    public MatchHistoryRequest accountId(final String accountId) {
        checkNotNull(accountId);
        this.queryParams.put(config.getAccountIdParam(), accountId);
        return this;
    }

    public MatchHistoryRequest leagueId(final String leagueId) {
        checkNotNull(leagueId);
        this.queryParams.put(config.getLeagueIdParam(), leagueId);
        return this;
    }

    public MatchHistoryRequest startAtMatchId(final String startAtMatchId) {
        checkNotNull(startAtMatchId);
        this.queryParams.put(config.getStartAtMatchIdParam(), startAtMatchId);
        return this;
    }

    public MatchHistoryRequest matchesRequested(final int matchesRequested) {
        checkIsTrue(matchesRequested > 0, "Matches requested should be a positive value");
        this.queryParams.put(config.getMatchesRequestedParam(), matchesRequested);
        return this;
    }

    public MatchHistoryRequest tournamentGamesOnly(final boolean tournamentGamesOnly) {
        this.queryParams.put(config.getMatchesRequestedParam(),
                tournamentGamesOnly ? "1" : "0");
        return this;
    }
}
