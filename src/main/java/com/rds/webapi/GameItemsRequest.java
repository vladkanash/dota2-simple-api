package com.rds.webapi;

import com.rds.config.ApiProperties;
import com.rds.service.WebService;
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
