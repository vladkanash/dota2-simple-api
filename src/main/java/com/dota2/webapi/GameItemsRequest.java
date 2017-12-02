package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

/**
 * Created by vladk on 17.06.2017.
 */

public class GameItemsRequest extends LanguageSpecific<ApiProperties.GameItems, GameItemsRequest> {

    GameItemsRequest(ApiProperties.GameItems requestConfig, WebService webService) {
        super(requestConfig, webService);
    }
}
