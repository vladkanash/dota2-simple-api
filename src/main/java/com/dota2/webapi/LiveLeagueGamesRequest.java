package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

public class LiveLeagueGamesRequest extends ApiRequest<ApiProperties.LiveLeagueGames> {

    LiveLeagueGamesRequest(ApiProperties.LiveLeagueGames requestConfig, WebService webService) {
        super(requestConfig, webService);
    }
}
