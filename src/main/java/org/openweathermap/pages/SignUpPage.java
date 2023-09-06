package org.openweathermap.pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class SignUpPage {
    private WebElement sugnUpPageTitle = $x("//h3[@class=\"first-child\"]");
    private WebElement usernameField = $x("//input[@id=\"user_username\"]");
    private WebElement emailField = $x("//input[@id=\"user_email\"]");
    private WebElement passwordField = $x("//input[@id=\"user_password\"]");
    private WebElement passwordConfirmationField = $x("//input[@id=\"user_password_confirmation\"]");
    private WebElement privacyPolicyText = $x("//div[@style='text-align: justify; text-justify: inter-word;']");
    private WebElement ageConfirmationCheckbox = $x("//input[@id=\"agreement_is_age_confirmed\"]");
    private WebElement agreementPrivacyPolicyCheckbox = $x("//input[@id=\"agreement_is_accepted\"]");
    private WebElement captchaCheckbox = $x("//div[@class=\"recaptcha-checkbox-border\"]");
    private WebElement acceptCaptchaButton = $x("//button[@id=\"recaptcha-verify-button\"]");
    private WebElement createAccountButton = $x("//input[@type=\"submit\" and @name='commit']");
    private WebElement captchaFrame = $x("//iframe[@title=\"reCAPTCHA\"]");

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
        switchTo().frame(captchaFrame);
        sleep(3000);
        acceptCaptchaButton.click();
    }
}
