package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

/**
 * Created by vladk on 15.10.2017.
 */
public class GameHeroesRequest extends LanguageSpecific<ApiProperties.GameHeroes, GameHeroesRequest> {

    GameHeroesRequest(ApiProperties.GameHeroes requestConfig, WebService webService) {
        super(requestConfig, webService);
    }

    public GameHeroesRequest itemizedOnly(final boolean itemizedOnly) {
        getQueryParams().put(getRequestConfig().getItemizedOnlyParam(),
                itemizedOnly ? "1" : "0");
        return this;
    }
}
