package com.vladkanash.webapi;

import com.vladkanash.config.ApiConfig;
import com.vladkanash.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladk on 17.06.2017.
 */

@Service
public class ApiService {

    private final ApiConfig apiConfig;
    private final WebService webService;

    @Autowired
    public ApiService(final ApiConfig apiConfig, final WebService webService) {
        this.apiConfig = apiConfig;
        this.webService = webService;
    }

    public MatchHistoryRequest matchHistory() {
        return new MatchHistoryRequest(apiConfig, webService);
    }

    public MatchDetailsRequest matchDetails(final long matchId) {
        return new MatchDetailsRequest(apiConfig, matchId, webService);
    }

    public GameItemsRequest gameItems() {
        return new GameItemsRequest(apiConfig, webService);
    }
}
