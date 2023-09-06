package org.openweathermap.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openweathermap.pages.MainPage;
import org.openweathermap.steps.BaseSteps;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.openweathermap.helpers.PropertyLoader.loadProperty;
@Slf4j
public class WeatherApi {

    MainPage mainPage = new MainPage();

    public String getUiCityName(){
        open(loadProperty("MainPage"));
        mainPage.enterDataToTheSearchContainer(loadProperty("CityName"));
        mainPage.clickOnTheSearchButton();
        mainPage.selectCityFromTheDropDown(1);
        String searchedCityName = mainPage.getSelectedCity();
        return searchedCityName;
    }
    public String getApiCityName(){
        String body = given().contentType(ContentType.HTML)
                .queryParam("appid", loadProperty("API_key"))
                .queryParam("q", loadProperty("CityName"))
                .get(loadProperty("API_url")).then().log().body()
                .extract().path("name");
        return body;
    }
}
