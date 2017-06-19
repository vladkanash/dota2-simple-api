package com.vladkanash.webapi;

import com.vladkanash.config.ApiProperties;
import com.vladkanash.service.WebService;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchDetailsRequest extends ApiRequest{

    MatchDetailsRequest(final ApiProperties apiProperties, final long matchId, WebService webService) {
        super(apiProperties.getMatchDetails().getUrl(), apiProperties, webService);

        this.queryParams.put(apiProperties.getMatchDetails().getMatchIdParam(), matchId);
    }
}
