package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchDetailsRequest extends ApiRequest<ApiProperties.MatchDetails>{

    MatchDetailsRequest(ApiProperties.MatchDetails requestConfig, WebService webService, final Long matchId) {
        super(requestConfig, webService);

        getQueryParams().put(getRequestConfig().getMatchIdParam(), matchId);
    }
}
