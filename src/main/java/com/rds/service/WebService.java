package com.rds.service;

import org.apache.http.HttpException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by vladk on 17.06.2017.
 */

public interface WebService {

    JSONObject getJson(final String url, final Map<String, Object> queryParams) throws HttpException;
}
