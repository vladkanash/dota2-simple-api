package com.rds.webapi;

import com.rds.config.ApiProperties;
import com.rds.service.WebService;
import org.apache.http.HttpException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladk on 17.06.2017.
 */

public class ApiRequest {

    private final String url;
    private final WebService webService;
    final Map<String, Object> queryParams = new HashMap<>();
    final ApiProperties apiProperties;

    ApiRequest(final String url, final ApiProperties apiProperties, final WebService webService) {
        this.url = url;
        this.apiProperties = apiProperties;
        this.webService = webService;
        this.queryParams.put(apiProperties.getApiKeyParam(), apiProperties.getApiKey());
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
}
