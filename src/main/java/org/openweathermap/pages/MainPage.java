package org.openweathermap.pages;

import com.codeborne.selenide.ElementsCollection;
import jdk.jfr.Name;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

@Name("Блок поиска")
public class MainPage {
    private WebElement searchContainer = $x("//div[@class=\"search\"]//input[@type=\"text\"]");
    private WebElement searchButton = $x("//div[@class=\"search\"]//button[@type=\"submit\"]");
    private WebElement nameOfSelectedCity = $x("//h2[@data-v-3e6e9f12=\"\"]");
    private WebElement signInButton = $x("//a[text()='Sign in']");
    private ElementsCollection searchResult = $$x("//ul[@class='search-dropdown-menu']/li");



    public void enterDataToTheSearchContainer(String cityName){
        searchContainer.sendKeys(cityName);
    }
    public void clickOnTheSearchButton(){
        searchButton.click();
    }

    public void selectCityFromTheDropDown(int numberOfCity) {
        int elementNumber = numberOfCity - 1;
        if (elementNumber >= 0 && elementNumber < searchResult.size()) {
            searchResult.get(elementNumber).click();
        } else {
            System.out.println("Некорректный номер города: " + numberOfCity);
        }
    }

    public String getSelectedCity (){
        String selectedCity = nameOfSelectedCity.getText();
        return selectedCity;
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }
}
