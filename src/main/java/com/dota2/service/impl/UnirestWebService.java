package com.dota2.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.dota2.service.WebService;
import org.apache.http.HttpException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by vladk on 17.06.2017.
 */

public class UnirestWebService implements WebService {

    @Override
    public JSONObject getJson(String url, Map<String, Object> queryParams) throws HttpException {
        HttpResponse<JsonNode> result;
        try {
            result = Unirest.get(url)
                    .queryString(queryParams)
                    .asJson();
            if (result.getBody() == null) throw new HttpException("Response body is null!, url=" + url);
        } catch (UnirestException e) {
            throw new HttpException("An error occurred while trying to process request to " + url, e);
        }

        return result.getBody().getObject();
    }
}
