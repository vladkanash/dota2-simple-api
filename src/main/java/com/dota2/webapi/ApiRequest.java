package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;
import org.apache.http.HttpException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladk on 17.06.2017.
 */

public class ApiRequest<T extends ApiProperties.BaseRequestConfig> {

    private final String url;
    private final WebService webService;
    private final Map<String, Object> queryParams = new HashMap<>();
    private final T requestConfig;

      ApiRequest(final T requestConfig, final WebService webService) {
        this.url = requestConfig.getUrl();
        this.webService = webService;
        this.queryParams.put(requestConfig.getApiKeyParam(), requestConfig.getApiKey());
        this.requestConfig = requestConfig;
    }

    public JSONObject get() {
        JSONObject result = null;
        try {
            result = webService.getJson(url, queryParams);
        } catch (HttpException e) {
            e.printStackTrace();
        }
        return result;
    }

    T getRequestConfig() {
        return this.requestConfig;
    }

    Map<String, Object> getQueryParams() {
        return this.queryParams;
    }
}
