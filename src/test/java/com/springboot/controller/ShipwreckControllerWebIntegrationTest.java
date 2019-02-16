package com.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


//@SpringApplicationConfiguration(classes = Application.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)// 2
@WebAppConfiguration   // 3
//@IntegrationTest("server.port:0")
public class ShipwreckControllerWebIntegrationTest {

    @Test
    public void testlistAll() throws IOException {


    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8086", String.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ObjectMapper objectMapper = new ObjectMapper();

       // JsonNode  responseJson = objectMapper.readTree(response.getBody());

      // assertThat(responseJson.isMissingNode()).isFalse();
      // assertThat(responseJson.toString()).isEqualTo("[]");
}

}
