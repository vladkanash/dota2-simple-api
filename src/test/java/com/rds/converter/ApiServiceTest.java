package com.rds.converter;

import com.rds.config.ApiConfig;
import com.rds.webapi.ApiService;
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
@SpringBootTest(classes = {ApiConfig.class})
public class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    @Test
    public void getGameItemsTest() throws Exception {
        final JSONObject result = apiService.gameItems().get();
        assertNotNull(result);
    }

    @Test
    public void getGameHeroesTest() throws Exception {
        final JSONObject result = apiService.gameHeroes().itemizedOnly(true).get();
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
                .matchesRequested(4).get();

        assertNotNull(result);
        assertEquals(4, result
                .getJSONObject("result")
                .getJSONArray("matches")
                .length());
    }

    @Test
    public void getMatchDetailsTest() throws Exception {
        final Long matchId = apiService.matchHistory()
                .matchesRequested(1)
                .get()
                .getJSONObject("result")
                .getJSONArray("matches")
                .getJSONObject(0)
                .getLong("match_id");

        final JSONObject result = apiService.matchDetails(matchId).get();
        assertNotNull(result);
        assertEquals((long) matchId, result.getJSONObject("result").getLong("match_id"));
    }
}