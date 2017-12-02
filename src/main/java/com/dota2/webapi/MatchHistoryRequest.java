package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

import static com.dota2.util.Validation.checkIsTrue;
import static com.dota2.util.Validation.checkNotNull;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchHistoryRequest extends ApiRequest<ApiProperties.MatchHistory> {

    MatchHistoryRequest(ApiProperties.MatchHistory requestConfig, WebService webService) {
        super(requestConfig, webService);
    }

    public MatchHistoryRequest heroId(final long heroId) {
        checkIsTrue(heroId > 0, "heroId must be positive value");
        getQueryParams().put(getRequestConfig().getHeroIdParam(), heroId);
        return this;
    }

    public MatchHistoryRequest gameMode(final long gameMode) {
        checkIsTrue(gameMode >= 0 && gameMode <= 16,
                "gameMode value is not valid");
        getQueryParams().put(getRequestConfig().getGameModeParam(), gameMode);
        return this;
    }

    public MatchHistoryRequest skill(final long skill) {
        checkIsTrue(skill >= 0 && skill <= 3,
                "skill value is not valid");
        getQueryParams().put(getRequestConfig().getSkillParam(), skill);
        return this;
    }

    public MatchHistoryRequest minPlayers(final String minPlayers) {
        checkNotNull(minPlayers);
        getQueryParams().put(getRequestConfig().getMinPlayersParam(), minPlayers);
        return this;
    }

    public MatchHistoryRequest accountId(final String accountId) {
        checkNotNull(accountId);
        getQueryParams().put(getRequestConfig().getAccountIdParam(), accountId);
        return this;
    }

    public MatchHistoryRequest leagueId(final String leagueId) {
        checkNotNull(leagueId);
        getQueryParams().put(getRequestConfig().getLeagueIdParam(), leagueId);
        return this;
    }

    public MatchHistoryRequest startAtMatchId(final String startAtMatchId) {
        checkNotNull(startAtMatchId);
        getQueryParams().put(getRequestConfig().getStartAtMatchIdParam(), startAtMatchId);
        return this;
    }

    public MatchHistoryRequest matchesRequested(final int matchesRequested) {
        checkIsTrue(matchesRequested > 0, "Matches requested should be a positive value");
        getQueryParams().put(getRequestConfig().getMatchesRequestedParam(), matchesRequested);
        return this;
    }

    public MatchHistoryRequest tournamentGamesOnly(final boolean tournamentGamesOnly) {
        getQueryParams().put(getRequestConfig().getMatchesRequestedParam(),
                tournamentGamesOnly ? "1" : "0");
        return this;
    }
}
