package edu.upc.gessi.glidebackend.controller;


import edu.upc.gessi.glidebackend.service.LeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/leaderboards")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getLeaderboard(@PathVariable("id") Long leaderboardId) {
        Object leaderboard = leaderboardService.getLeaderboard(leaderboardId);
        return ResponseEntity.ok(leaderboard);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/{id}/results")
    public ResponseEntity<?> getLeaderboardResults(@PathVariable("id") Long leaderboardId) {
        List<Object> leaderboardResults = leaderboardService.getLeaderboardResults(leaderboardId);
        return ResponseEntity.ok(leaderboardResults);
    }
}
