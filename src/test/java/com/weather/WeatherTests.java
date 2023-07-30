package com.weather;

import org.testng.annotations.Test;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class WeatherTests {

    //Test1
    @Test(priority = 1)
    public void getWeatherDataInWellingtonWithValidDetails(){

        given().queryParam("latitude", "-41.2866")
               .queryParam("longitude","174.7756")
               .queryParam("hourly","weathercode")
               .when()
               .get("https://api.open-meteo.com/v1/forecast")
               .then()
               .assertThat().statusCode(200)
               .assertThat().header("Content-Type", equalTo("application/json; charset=utf-8"))
               .assertThat().body("latitude", equalTo(-41.25F))
               .log().all();
    }

    //Test2
    @Test(priority = 2)
    public void getWeatherDataInAucklandWithValidDetails(){

        given().queryParam("latitude", "-36.8485")
               .queryParam("longitude","174.7635")
               .queryParam("daily","weathercode,sunrise")
               .queryParam("timezone", "Pacific/Auckland")
               .when()
               .get("https://api.open-meteo.com/v1/forecast")
               .then()
               .assertThat().statusCode(200)
               .assertThat().header("Content-Type", equalTo("application/json; charset=utf-8"))
               .assertThat().body("latitude", equalTo(-36.875F))
               .log().all();
    }

    //Test3
    @Test(priority = 3)
    public void getWeatherDataInAucklandWithResponseBody(){

        ArrayList<String> sr =
                given()
                        .queryParam("latitude", "-36.8485")
                        .queryParam("longitude","174.7635")
                        .queryParam("daily","weathercode,sunrise")
                        .queryParam("timezone", "Pacific/Auckland")
                        .when()
                        .get("https://api.open-meteo.com/v1/forecast")
                        .then().extract().path("daily.sunrise") ;

        //Traverse through the array list.
        for(String a:sr){
            System.out.println("sunrise at:  "+a);

        }
    }

    //Test4
    @Test(priority = 4)
    public void getWeatherDataInAucklandWithNoMandatoryField(){

        given().queryParam("latitude", "-36.8485")
                .queryParam("longitude","174.7635")
                .queryParam("daily","weathercode,sunrise")
                .when()
                .get("https://api.open-meteo.com/v1/forecast")
                .then()
                .assertThat().statusCode(400)
                .assertThat().header("Content-Type", equalTo("application/json; charset=utf-8"))
                .assertThat().body("error", equalTo(true))
                .assertThat().body("reason", equalTo("Timezone is required"))
                .log().all();
    }

}
