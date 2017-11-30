package com.rds.webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.rds.config.*;
import com.rds.service.WebService;
import com.rds.service.impl.UnirestWebService;

import java.io.IOException;
import java.net.URL;

/**
 * Created by vladk on 17.06.2017.
 */

public class ApiService {

    private final ApiProperties apiProperties;
    private final WebService webService;

    public ApiService(final String apiKey) {
        this(apiKey, new UnirestWebService());
    }

    public ApiService(final String apiKey, final WebService webService) {
        this.webService = webService;
        this.apiProperties = initApiProperties();
        this.apiProperties.setApiKey(apiKey);
    }

    private ApiProperties initApiProperties() {
        ApiProperties properties = null;
        final YAMLFactory factory = new YAMLFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        try {
            final URL resource = ClassLoader.getSystemClassLoader().getResource("config/dota2api.yml");
            properties = mapper.readValue(resource, ApiProperties.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
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

    public GameHeroesRequest gameHeroes() {return new GameHeroesRequest(apiProperties, webService);}
}
