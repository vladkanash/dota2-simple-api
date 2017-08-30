package com.rds.webapi;

import com.rds.config.ApiProperties;
import com.rds.service.WebService;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchDetailsRequest extends ApiRequest{

    MatchDetailsRequest(final ApiProperties apiProperties, final long matchId, WebService webService) {
        super(apiProperties.getMatchDetails().getUrl(), apiProperties, webService);

        this.queryParams.put(apiProperties.getMatchDetails().getMatchIdParam(), matchId);
    }
}
