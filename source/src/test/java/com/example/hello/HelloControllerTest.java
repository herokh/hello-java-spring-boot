package com.example.hello;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("Send name to say hi. expected result Hello {name}")
    void sayHi_Success() {
        // Arrange
        var user = new User();
        user.setName("testing");
        when(userRepository.findByName("testing")).thenReturn(Optional.of(user));
        // Act
        HelloResponse helloResponse = testRestTemplate.getForObject("/hello/testing", HelloResponse.class);
        // Assert
        assertEquals("Hello testing", helloResponse.getMessage());
    }

    @Test
    @DisplayName("Send name to say hi. expected result User not found")
    void sayHi_NotFound() {
        // Act
        HelloResponse helloResponse = testRestTemplate.getForObject("/hello/test", HelloResponse.class);
        // Assert
        assertEquals("User test not found", helloResponse.getMessage());
    }
}