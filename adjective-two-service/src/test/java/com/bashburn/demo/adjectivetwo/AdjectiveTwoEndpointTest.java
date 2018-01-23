package com.bashburn.demo.adjectivetwo;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdjectiveTwoEndpointTest {
  @Value("${local.server.port}")
  private int port;

  @Before
  public void setup() {
    RestAssured.baseURI = String.format("http://localhost:%s/api", port);
  }

  @Test
  public void testGetSecondAdjective() {
    RestAssured
        .when()
          .get("adjective")
        .then()
          .assertThat()
            .statusCode(200)
            .body(notNullValue());
  }
}
