package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

import static com.dota2.util.Validation.checkNotNull;

/**
 * Created by vladk on 15.10.2017.
 */
public class GameHeroesRequest extends ApiRequest {

    GameHeroesRequest(ApiProperties apiProperties, WebService webService) {
        super(apiProperties.getGameHeroes().getUrl(), apiProperties, webService);
    }

    public GameHeroesRequest language(final String language) {
        checkNotNull(language);

        this.queryParams.put(
                this.apiProperties.getGameItems().getLanguageParam(), language);
        return this;
    }

    public GameHeroesRequest itemizedOnly(final boolean itemizedOnly) {
        this.queryParams.put(this.apiProperties.getGameHeroes().getItemizedParam(),
                itemizedOnly ? "1" : "0");
        return this;
    }
}
