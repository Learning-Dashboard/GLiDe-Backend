package edu.upc.gessi.glidebackend.service.impl;

import edu.upc.gessi.glidebackend.service.MetricService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MetricServiceImpl implements MetricService {

    @Value("${learningdashboard.api.base-url}")
    private String learningDashboardAPIBaseURL;

    @Override
    public List<Object> getAllCategories() {
        try {
            String uri= learningDashboardAPIBaseURL + "/metrics/categories";
            RestTemplate restTemplate = new RestTemplate();
            Object[] categories = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(categories);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public List<Object> getProjectCategories(String prj) {
        try {
            String uri= learningDashboardAPIBaseURL + "/metrics?prj=" + prj;
            RestTemplate restTemplate = new RestTemplate();
            Object[] projectCategories = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(projectCategories);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public List<Object> getMetrics(String prj) {
        try {
            String uri= learningDashboardAPIBaseURL + "/metrics/students?prj=" + prj;
            RestTemplate restTemplate = new RestTemplate();
            Object[] metrics = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(metrics);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public List<Object> getProjectMetrics(String prj) {
        try {
            String uri= learningDashboardAPIBaseURL + "/metrics/current?prj=" + prj;
            RestTemplate restTemplate = new RestTemplate();
            Object[] metrics = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(metrics);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public List<Object> getMetricsHistory(String prj, String from, String to) {
        try {
            String uri= learningDashboardAPIBaseURL + "/metrics/students/historical?prj=" + prj + "&from=" + from + "&to=" + to;
            RestTemplate restTemplate = new RestTemplate();
            Object[] metrics = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(metrics);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public List<Object> getProjectMetricsHistory(String prj, String from, String to) {
        try {
            String uri= learningDashboardAPIBaseURL + "/metrics/historical?prj=" + prj + "&from=" + from + "&to=" + to;
            RestTemplate restTemplate = new RestTemplate();
            Object[] metrics = restTemplate.getForObject(uri, Object[].class);
            return Arrays.asList(metrics);
        }catch (Exception e){
            e.printStackTrace();
            return Collections.singletonList(new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }



}
