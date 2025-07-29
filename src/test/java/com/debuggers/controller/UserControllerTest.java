package com.debuggers.controller;

import com.debuggers.domain.User;
import com.debuggers.factory.UserFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/api/users/";

    // Sample test user created using the factory
    private static final User user = UserFactory.createUser(
            1L,
            "Devin",
            "Booker",
            "booker@gmail.com",
            "Devin@1"
    );

    @Test
    @Order(1)
    public void create() {
        String url = baseURL + "create";
        System.out.println("📤 Post data: " + user);

        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);

        System.out.println("✅ Saved data: " + postResponse.getBody());
    }

//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;

//    private static User testUser;
//
//    private String getBaseUrl() {
//        return "http://localhost:" + port + "/api/users";
//    }
//
//    @BeforeAll
//    static void setupData() {
//        testUser = UserFactory.createUser(
//                UserFactory.createUserId(),
//                "Thabo",
//                "Mokoena",
//                "thabo@example.com",
//                "StrongPass123"
//        );
//    }

//    @Test
//    @Order(1)
//    void create() {
//        String url = getBaseUrl() + "/create";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<User> request = new HttpEntity<>(testUser, headers);
//
//        ResponseEntity<User> response = restTemplate.postForEntity(url, request, User.class);
//
//        System.out.println("✅ Created User: " + response.getBody());
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals("Thabo", response.getBody().getFirstName());
//        System.out.println("✅ Created User: " + response.getBody());
//    }

//    @Test
//    @Order(1)
//    void create() {
//        String url = baseURL + "create";
//        System.out.println("📤 Sending User: " + testUser);
//
//        ResponseEntity<User> response = restTemplate.postForEntity(url, testUser, User.class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        System.out.println("✅ Created User: " + response.getBody());
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        String url = baseURL + "read/" + testUser.getId();
//        System.out.println("📥 Reading from: " + url);
//
//        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        System.out.println("👀 Read User: " + response.getBody());
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        User updatedUser = new User.Builder()
//                .copy(testUser)
//                .setEmailAddress("updated@example.com")
//                .build();
//
//        String url = baseURL + "update";
//        ResponseEntity<User> response = restTemplate.postForEntity(url, updatedUser, User.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("updated@example.com", response.getBody().getEmailAddress());
//        System.out.println("🔁 Updated User: " + response.getBody());
//    }
//
//    @Test
//    @Order(4)
//    void getAll() {
//        String url = baseURL + "all";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        System.out.println("📄 All Users: " + response.getBody());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        String url = baseURL + "delete/" + testUser.getId();
//        restTemplate.delete(url);
//        System.out.println("🗑️ Deleted User at: " + url);
//    }
}