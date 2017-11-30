package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;
import org.apache.commons.lang3.Validate;

/**
 * Created by vladk on 17.06.2017.
 */

public class GameItemsRequest extends ApiRequest {

    GameItemsRequest(ApiProperties apiProperties, WebService webService) {
        super(apiProperties.getGameItems().getUrl(), apiProperties, webService);
    }

    public GameItemsRequest language(final String language) {
        Validate.notBlank(language);

        this.queryParams.put(
                this.apiProperties.getGameItems().getLanguageParam(), language);
        return this;
    }
}
