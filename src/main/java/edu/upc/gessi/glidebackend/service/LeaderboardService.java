package edu.upc.gessi.glidebackend.service;

import java.util.List;

public interface LeaderboardService {

    Object getLeaderboard(Long leaderboardId);

    List<Object> getLeaderboardResults(Long leaderboardId);

}
