package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

public class MatchHistoryBySeqNumRequest extends ApiRequest<ApiProperties.MatchHistoryBySeqNum> {

    MatchHistoryBySeqNumRequest(ApiProperties.MatchHistoryBySeqNum requestConfig, WebService webService) {
        super(requestConfig, webService);
    }

    public MatchHistoryBySeqNumRequest startAtMatchSeqNum(final long startAtMatchSeqNum) {
        getQueryParams().put(getRequestConfig().getStartAtMatchSeqNumParam(), startAtMatchSeqNum);
        return this;
    }

    public MatchHistoryBySeqNumRequest matchesRequested(final int matchesRequested) {
        getQueryParams().put(getRequestConfig().getMatchesRequestedParam(), matchesRequested);
        return this;
    }
}
