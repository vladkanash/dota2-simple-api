package com.rds.webapi;

import com.rds.config.ApiProperties;
import com.rds.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladk on 17.06.2017.
 */

@Service
public class ApiService {

    private final ApiProperties apiProperties;
    private final WebService webService;

    @Autowired
    public ApiService(final ApiProperties apiProperties, final WebService webService) {
        this.apiProperties = apiProperties;
        this.webService = webService;
    }

    public MatchHistoryRequest matchHistory() {
        return new MatchHistoryRequest(apiProperties, webService);
    }

    public MatchDetailsRequest matchDetails(final long matchId) {
        return new MatchDetailsRequest(apiProperties, matchId, webService);
    }

    public GameItemsRequest gameItems() {
        return new GameItemsRequest(apiProperties, webService);
    }
}
