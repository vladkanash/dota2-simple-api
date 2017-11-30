package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchDetailsRequest extends ApiRequest{

    MatchDetailsRequest(final ApiProperties apiProperties, final long matchId, WebService webService) {
        super(apiProperties.getMatchDetails().getUrl(), apiProperties, webService);

        this.queryParams.put(apiProperties.getMatchDetails().getMatchIdParam(), matchId);
    }
}
