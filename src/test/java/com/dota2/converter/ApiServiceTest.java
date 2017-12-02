package com.dota2.converter;

import com.dota2.webapi.ApiService;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by vladk on 16.06.2017.
 */

public class ApiServiceTest {

    private ApiService apiService = new ApiService("47739846B894FDBB8448CD2685BF9DDE");

    @Test
    public void getGameItemsTest() {
        final JSONObject result = apiService.gameItems().get();
        assertNotNull(result);
    }

    @Test
    public void getGameHeroesTest() {
        final JSONObject result = apiService.gameHeroes().itemizedOnly(true).get();
        assertNotNull(result);
    }

    @Test
    public void getMatchHistoryTest() {
        final JSONObject result = apiService.matchHistory().get();
        assertNotNull(result);
    }

    @Test
    public void getMatchHistoryMatchesCountTest() {
        final JSONObject result = apiService.matchHistory()
                .matchesRequested(4).get();

        assertNotNull(result);
        assertEquals(4, result
                .getJSONObject("result")
                .getJSONArray("matches")
                .length());
    }

    @Test
    public void getMatchDetailsTest() {
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

    @Test
    public void leagueListingTest()  {
        final JSONObject jsonResult = apiService.leagueListing()
                .language(Locale.FRANCE)
                .get()
                .getJSONObject("result");

        assertNotNull(jsonResult);
    }

    @Test
    public void liveLeagueGamesTest() {
        final JSONObject jsonResult = apiService.liveLeagueGames().get();

        assertNotNull(jsonResult);
    }

    @Test
    public void matchHistoryBySeqNumTest() {
        final JSONObject jsonResult = apiService.matchHistoryBySequenceNum()
                .matchesRequested(10)
                .get();

        assertNotNull(jsonResult);
    }
}