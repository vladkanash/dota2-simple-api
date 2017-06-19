package com.vladkanash.webapi;

import com.vladkanash.config.ApiConfig;
import com.vladkanash.service.WebService;
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
    final ApiConfig apiConfig;

    ApiRequest(final String url, final ApiConfig apiConfig, final WebService webService) {
        this.url = url;
        this.apiConfig = apiConfig;
        this.webService = webService;
        this.queryParams.put(apiConfig.getKeyParam(), apiConfig.getKey());
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
