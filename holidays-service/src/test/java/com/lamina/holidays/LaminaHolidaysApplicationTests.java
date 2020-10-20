package com.lamina.holidays;

import com.lamina.holidays.entity.Holiday;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaminaHolidaysApplicationTests {/*

    @LocalServerPort
    int randomServerPort;

    @Test
    @DisplayName("Get all Holidays")
    public void testGetAllHolidays() throws URISyntaxException {
        URI uri = new URI(getURL(""));
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity entity = new HttpEntity(null, headers);

        ResponseEntity<Set> responseEntity = template.exchange(uri, HttpMethod.GET, entity, Set.class);
        Assertions.assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotEquals(0, responseEntity.getBody().size())
        );
    }

    @Test
    @DisplayName("Get Holidays By Id")
    public void testGetHolidayById() throws URISyntaxException {
        final String id = "1";
        URI uri = new URI(getURL("/id/" + id));
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Holiday> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Holiday> responseEntity = template.exchange(uri, HttpMethod.GET, entity, Holiday.class);

        Assertions.assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertEquals(Integer.valueOf(id), responseEntity.getBody().getId())
        );
    }

    @Test
    @DisplayName("Get Holidays By Name")
    public void testGetHolidaysByName() throws URISyntaxException {
        final String name = "new";
        URI uri = new URI(getURL("/name/" + name));
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Set> entity = new HttpEntity<>(null, headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<Set> responseEntity = template.exchange(uri, HttpMethod.GET, entity, Set.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(false, responseEntity.getBody().isEmpty());
    }

    @Test
    @DisplayName("Get Holidays By Year")
    public void testGetHolidaysByYear() throws URISyntaxException {
        final String url = "/year/2020";
        URI uri = new URI(getURL(url));
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Set> entity = new HttpEntity<>(null, headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<Set> responseEntity = template.exchange(uri, HttpMethod.GET, entity, Set.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(false, responseEntity.getBody().isEmpty());
    }

    private String getURL(String uri) {
        return new StringBuilder("http://localhost:")
                .append(randomServerPort)
                .append("/holidays")
                .append(uri)
                .toString();
    }*/
}
