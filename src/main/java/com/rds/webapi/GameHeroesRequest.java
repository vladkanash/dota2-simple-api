package com.rds.webapi;

import com.rds.config.ApiProperties;
import com.rds.service.WebService;
import org.apache.commons.lang3.Validate;

/**
 * Created by vladk on 15.10.2017.
 */
public class GameHeroesRequest extends ApiRequest {

    GameHeroesRequest(ApiProperties apiProperties, WebService webService) {
        super(apiProperties.getGameHeroes().getUrl(), apiProperties, webService);
    }

    public GameHeroesRequest language(final String language) {
        Validate.notBlank(language);

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
