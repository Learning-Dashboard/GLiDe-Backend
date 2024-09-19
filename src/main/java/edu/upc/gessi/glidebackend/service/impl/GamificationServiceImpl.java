package edu.upc.gessi.glidebackend.service.impl;

import edu.upc.gessi.glidebackend.service.GamificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GamificationServiceImpl implements GamificationService {


    @Value("${gamification.api.base-url}")
    private String gamificationAPIBaseURL;

    @Override
    public Object getIndividualPlayer(String individualPlayerPlayername) {
        try {
            String uri = gamificationAPIBaseURL + "/players/individuals/" + individualPlayerPlayername;
            RestTemplate restTemplate = new RestTemplate();
            Object individualPlayer = restTemplate.getForObject(uri, Object.class);
            return individualPlayer;
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public Object getTeamPlayer(String teamPlayerPlayername) {
        try {
            String uri = gamificationAPIBaseURL + "/players/teams/" + teamPlayerPlayername;
            RestTemplate restTemplate = new RestTemplate();
            Object teamPlayer = restTemplate.getForObject(uri, Object.class);
            return teamPlayer;
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public List<Object> getPlayerAchievements(String teamPlayerPlayername, String attained, String category) {
        try {
            String uri = gamificationAPIBaseURL + "/players/" + teamPlayerPlayername + "/achievements?attained=" + attained + "&category=" + category;
            RestTemplate restTemplate = new RestTemplate();
            Object[] achievements = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(achievements);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}
