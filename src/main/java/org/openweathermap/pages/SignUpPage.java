package org.openweathermap.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Selenide.*;

public class SignUpPage {
    private final SelenideElement sugnUpPageTitle = $x("//h3[@class=\"first-child\"]");
    private final SelenideElement usernameField = $x("//input[@id=\"user_username\"]");
    private final SelenideElement emailField = $x("//input[@id=\"user_email\"]");
    private final SelenideElement passwordField = $x("//input[@id=\"user_password\"]");
    private final SelenideElement passwordConfirmationField = $x("//input[@id=\"user_password_confirmation\"]");
    private final SelenideElement privacyPolicyText = $x("//div[@style='text-align: justify; text-justify: inter-word;']");
    private final SelenideElement ageConfirmationCheckbox = $x("//input[@id=\"agreement_is_age_confirmed\"]");
    private final SelenideElement agreementPrivacyPolicyCheckbox = $x("//input[@id=\"agreement_is_accepted\"]");
    private final SelenideElement captchaCheckbox = $x("//div[@class=\"recaptcha-checkbox-border\"]");
    private final SelenideElement acceptCaptchaButton = $x("//button[@id=\"recaptcha-verify-button\"]");
    private final SelenideElement createAccountButton = $x("//input[@type=\"submit\" and @name='commit']");
    private final SelenideElement captchaFrame = $x("//iframe[1]");

    public void signUpPageIsLoaded(){
        sugnUpPageTitle.isDisplayed();
        usernameField.isDisplayed();
        emailField.isDisplayed();
        passwordField.isDisplayed();
        passwordConfirmationField.isDisplayed();
        privacyPolicyText.isDisplayed();
        ageConfirmationCheckbox.isDisplayed();
        agreementPrivacyPolicyCheckbox.isDisplayed();
        captchaCheckbox.isDisplayed();
    }
    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }
    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void enterPasswordConfirmation(String password){
        passwordConfirmationField.sendKeys(password);
    }

    public void selectAgeConfirmationCheckbox(){
        ageConfirmationCheckbox.click();
    }

    public void selectAgreementPrivacyPolicyCheckbox(){
        agreementPrivacyPolicyCheckbox.click();
    }

    public void selectCaptchaCheckbox(){
        switchTo().frame(captchaFrame);
        captchaCheckbox.click();
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }

    public void clickOnAcceptCaptchaButton(){
        sleep(3000);
        switchTo().frame(captchaFrame);
        sleep(3000);
        acceptCaptchaButton.click();
        switchTo().defaultContent();
    }

    public void clickOnTheCreateAccountButton(){
        switchTo().defaultContent();
        createAccountButton.click();
    }
}
