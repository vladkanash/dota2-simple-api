package com.vladkanash.webapi;

import com.vladkanash.config.ApiConfig;
import com.vladkanash.service.WebService;
import org.apache.commons.lang3.Validate;

/**
 * Created by vladk on 17.06.2017.
 */

public class GameItemsRequest extends ApiRequest {

    GameItemsRequest(ApiConfig apiConfig, WebService webService) {
        super(apiConfig.getGameItems().getUrl(), apiConfig, webService);
    }

    public GameItemsRequest language(final String language) {
        Validate.notBlank(language);

        this.queryParams.put(
                this.apiConfig.getGameItems().getLanguageParam(), language);
        return this;
    }
}
