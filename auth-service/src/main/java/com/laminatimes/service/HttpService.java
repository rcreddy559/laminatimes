package com.laminatimes.service;

import com.laminatimes.config.ProsConfig;
import com.laminatimes.entity.UserResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class HttpService {
    static Logger log = LogManager.getLogger(HttpService.class);

    @Autowired
    ProsConfig exchangeConfig;

    public UserResponse getUserDetails(String userName) throws IOException, InterruptedException {
        log.info("getUserDetails-------------->> {}, : {}", userName,getUri(userName));

        final HttpRequest request = HttpRequest.newBuilder(getUri(userName))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .GET().build();
        request.headers();
        final HttpResponse<UserResponse> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(UserResponse.class));
        return response.body();
    }

    public URI getUri(String userName) {
        return URI.create("http://localhost:8123/user/username/"+userName);
    }
}
