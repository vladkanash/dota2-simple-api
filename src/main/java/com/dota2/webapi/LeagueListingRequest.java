package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

public class LeagueListingRequest extends LanguageSpecific<ApiProperties.LeagueListing, LeagueListingRequest>{

    LeagueListingRequest(ApiProperties.LeagueListing requestConfig, WebService webService) {
        super(requestConfig, webService);
    }
}
