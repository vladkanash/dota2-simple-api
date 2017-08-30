package com.rds.dto.json;

/**
 * Created by vladk on 17.06.2017.
 */

public class MatchSummary {

    private Long matchId;
    private Long lobbyType;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getLobbyType() {
        return lobbyType;
    }

    public void setLobbyType(Long lobbyType) {
        this.lobbyType = lobbyType;
    }
}
