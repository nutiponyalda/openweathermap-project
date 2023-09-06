package org.openweathermap.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherApiTest {
    @Test
    public void city(){
        WeatherApi weatherApi = new WeatherApi();
        String uiResult = weatherApi.getUiCityName();
        String apiResult = weatherApi.getApiCityName();
        Assertions.assertTrue(uiResult.contains(apiResult));
    }
}
