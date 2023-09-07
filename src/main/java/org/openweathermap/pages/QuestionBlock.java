package org.openweathermap.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class QuestionBlock {
    private static SelenideElement questionTitle = $x("//div[@class=\"modal-header\"]");
    private static SelenideElement questionText = $x("//div[@class=\"modal-body\"]/p");
    private static SelenideElement companyName = $x("//input[@id=\"poll_company\"]");
    private static SelenideElement purposeSelector = $x("//select[@id=\"poll_purpose\"]");

    public void questionBlockIsLoaded(){
        questionTitle.isDisplayed();
        questionText.isDisplayed();
        companyName.isDisplayed();
        purposeSelector.isDisplayed();
    }
}
