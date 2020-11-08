package com.lamina.user.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lamina.user.response.StockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
public class HttpUserService {
    Logger logger= LoggerFactory.getLogger(HttpUserService.class);

    @Value("${url.stock}")
    String stockUrl;

    public StockResponse getStock(Integer userId) throws IOException, InterruptedException {
        logger.info("getUserDetails-------------->> {}, : ==?{}: -->>>{}", userId,getUri(userId), stockUrl);

        final java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder(getUri(userId))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .GET().build();
        request.headers();

        final HttpResponse<StockResponse> response
                = java.net.http.HttpClient
                .newHttpClient()
                .send(request, new JsonBodyHandler<>(StockResponse.class));
        return response.body();
    }

    public List<StockResponse> getAllStock(Integer userId) throws IOException, InterruptedException {
        logger.info("getUserDetails-----------response--->> {}, : ==?{}: -->>>{}", userId,getUri(userId), stockUrl);

        final java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder(getUri(userId))
                .timeout(Duration.ofSeconds(10))
                .GET().build();

        final HttpResponse<ArrayList<StockResponse>> response
                = java.net.http.HttpClient
                .newHttpClient()
                .send(request, new JsonBodyHandler(Object.class));

        return response.body();
    }

    public URI getUri(Integer userId) {
        return URI.create(stockUrl);
    }
}
