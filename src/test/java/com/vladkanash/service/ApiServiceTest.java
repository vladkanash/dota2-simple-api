package com.vladkanash.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vladkanash.config.Application;
import com.vladkanash.dto.json.MatchSummary;
import com.vladkanash.webapi.ApiService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by vladk on 16.06.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    @Test
    public void getGameItemsTest() throws Exception {
        final JSONObject result = apiService.gameItems().get();
        assertNotNull(result);
    }

    @Test
    public void getMatchHistoryTest() throws Exception {
        final JSONObject result = apiService.matchHistory().get();
        assertNotNull(result);
    }

    @Test
    public void getMatchHistoryMatchesCountTest() throws Exception {
        final JSONObject result = apiService.matchHistory()
                .matchesRequested("4").get();

        assertNotNull(result);
        assertEquals(4, result
                .getJSONObject("result")
                .getJSONArray("matches")
                .length());
    }

    @Test
    public void getMatchDetailsTest() throws Exception {
        final Long matchId = apiService.matchHistory()
                .matchesRequested("1")
                .get()
                .getJSONObject("result")
                .getJSONArray("matches")
                .getJSONObject(0)
                .getLong("match_id");

        final JSONObject result = apiService.matchDetails(matchId).get();
        assertNotNull(result);
        assertEquals((long) matchId, result.getJSONObject("result").getLong("match_id"));
    }

    @Test
    public void gsonTest() throws Exception {
        final JSONArray matchHistory = apiService.matchHistory()
                .get()
                .getJSONObject("result")
                .getJSONArray("matches");

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        final MatchSummary[] summary = gson.fromJson(matchHistory.toString(), MatchSummary[].class);
    }

}