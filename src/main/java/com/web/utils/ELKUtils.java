package com.web.utils;

import com.web.enums.ConfigProperties;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public final class ELKUtils {

    private ELKUtils(){}

    public static void sendDetailsToELK(String testName, String status){
        if (PropertyUtils.get(ConfigProperties.SENDRESULTSTOELK).equalsIgnoreCase("yes")) {
            Map<String, String> map = new HashMap<>();
            map.put("testName", testName);
            map.put("status", status);
            map.put("executionTime", LocalDateTime.now().toString());

            Response response = given()
                    .log()
                    .all()
                    .body(map)
                    .when()
                    .post(PropertyUtils.get(ConfigProperties.ELKURL));

            Assert.assertEquals(response.statusCode(), 201);

        }



    }
}
