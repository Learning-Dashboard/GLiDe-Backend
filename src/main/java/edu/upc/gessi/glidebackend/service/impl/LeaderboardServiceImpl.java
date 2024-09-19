package edu.upc.gessi.glidebackend.service.impl;

import edu.upc.gessi.glidebackend.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    @Value("${gamification.api.base-url}")
    private String gamificationAPIBaseURL;

    public Object getLeaderboard(Long leaderboardId) {
        try {
            String uri = gamificationAPIBaseURL + "/leaderboards/" + leaderboardId;
            RestTemplate restTemplate = new RestTemplate();
            Object leaderboard = restTemplate.getForObject(uri, Object.class);
            return leaderboard;
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    public List<Object> getLeaderboardResults(Long leaderboardId) {
        try {
            String uri = gamificationAPIBaseURL + "/leaderboards/" + leaderboardId + "/results";
            RestTemplate restTemplate = new RestTemplate();
            Object[] leaderboardResults = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(leaderboardResults);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }
}
