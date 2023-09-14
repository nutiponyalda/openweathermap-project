package org.openweathermap.api;

import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.openweathermap.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;
import static org.openweathermap.helpers.PropertyLoader.loadProperty;
@Slf4j
public class WeatherApi {

    MainPage mainPage = new MainPage();

    public String getUiCityName(){
        open(loadProperty("MainPage"));
        mainPage.enterDataToTheSearchContainer(loadProperty("CityName"));
        mainPage.clickOnTheSearchButton();
        sleep(3000);
        mainPage.selectCityFromTheDropDown(1);
        sleep(3000);
        return mainPage.getSelectedCity();
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
