package org.openweathermap.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {
    private WebElement signInTitle = $x("//h3[@class='first-child']");
    private WebElement emailContainer = $x("//div[@class='input-group']//input[@type='email']");
    private WebElement passwordContainer = $x("//div[@class='input-group']//input[@type='password']");
    private WebElement signUpButton = $x("//a[text()='Create an Account.']");
    private WebElement rememberMeText = $x("//label[text()='Remember me']");
    private WebElement rememberMeCheckbox = $x("//input[@type=\"checkbox\"]");
    private WebElement submitPage = $x("//input[@type='submit' and @value='Submit']");

    private WebElement recoverPasswordButton = $x("//a[text()='Click here to recover.']");
    private WebElement searchResult = $x("//ul[@class=\"search-dropdown-menu\"]");



    public void signInPageIsLoaded(){
        signInTitle.isDisplayed();
        emailContainer.isDisplayed();
        passwordContainer.isDisplayed();
        signUpButton.isDisplayed();
        recoverPasswordButton.isDisplayed();
        searchResult.isDisplayed();
        rememberMeText.isDisplayed();
        submitPage.isDisplayed();
        rememberMeCheckbox.isDisplayed();
    }

    public void openSignUpPage(){
        signUpButton.click();
    }
}
