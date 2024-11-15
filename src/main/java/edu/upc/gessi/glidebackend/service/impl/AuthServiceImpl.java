package edu.upc.gessi.glidebackend.service.impl;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import edu.upc.gessi.glidebackend.excpetion.AuthorizationException;
import edu.upc.gessi.glidebackend.service.AuthService;
import org.springframework.stereotype.Service;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String getTokenMail(String idToken) {
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new GsonFactory();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList("122702758739-i03amus3knpj1g42q5aa372s03u0f8uu.apps.googleusercontent.com"))
                .build();

        try {
            GoogleIdToken googleIdToken = verifier.verify(idToken);
            if (idToken != null) {
                Payload payload = googleIdToken.getPayload();
                return payload.getEmail();
            } else {
                throw new AuthorizationException("Issue verifying idToken");
            }
        }
        catch (Exception e){
            throw new AuthorizationException("Issue verifying idToken");
        }
    }
}
