package com.vladkanash.webapi;

import com.vladkanash.config.ApiConfig;
import com.vladkanash.service.WebService;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchDetailsRequest extends ApiRequest{

    MatchDetailsRequest(final ApiConfig apiConfig, final long matchId, WebService webService) {
        super(apiConfig.getMatchDetails().getUrl(), apiConfig, webService);

        this.queryParams.put(apiConfig.getMatchDetails().getMatchIdParam(), matchId);
    }
}
