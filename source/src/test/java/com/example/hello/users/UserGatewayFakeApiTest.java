package com.example.hello.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
public class UserGatewayFakeApiTest {

    @Autowired
    private UserGateway userGateway;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void getPostById() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:userFakeApiResponse.json");
        InputStreamReader userFileReader = new InputStreamReader(resource.getInputStream());
        String userFakeJson = FileCopyUtils.copyToString(userFileReader);
        stubFor(get(urlPathEqualTo("/users/1"))
                .willReturn(aResponse()
                        .withBody(userFakeJson)
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)
                )
        );

        UserResponse result = userGateway.getUserById(1);

        assertEquals(1, result.getId());
        assertEquals("Test Name", result.getName());
        assertEquals("Test Username", result.getUsername());
    }
}
