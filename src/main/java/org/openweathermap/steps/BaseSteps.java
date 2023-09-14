package org.openweathermap.steps;
import io.cucumber.java.bg.И;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openweathermap.helpers.DataGenerator;
import org.openweathermap.pages.MainPage;
import org.openweathermap.pages.QuestionBlock;
import org.openweathermap.pages.SignInPage;
import org.openweathermap.pages.SignUpPage;
import static com.codeborne.selenide.Selenide.*;
import static org.openweathermap.helpers.PropertyLoader.loadProperty;

@Slf4j
public class BaseSteps extends BaseSeleniumTest {
    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();
    SignUpPage signUpPage = new SignUpPage();
    QuestionBlock questionBlock = new QuestionBlock();
    DataGenerator dataGenerator = new DataGenerator();
    private final String GENERATED_PASSWORD = generateNewPassword();


    public String generateNewPassword() {
        String generatedPassword = dataGenerator.getPassword();
        log.info("Generated password is: " + generatedPassword);
        return generatedPassword;
    }

    @И("открыта страница {string} из проперти файла")
    public void открытьСтраницуИзПропертиФайла(String pageName) {
        String url = loadProperty(pageName);
        open(url);
    }

    @И("^выполнено ожидание в течение (\\d+) (?:секунд|секунды)")
    public void waitForSeconds(long seconds) {
        sleep(1000 * seconds);
    }

    @When("Ввести в поисковую строку название города {string} из проперти файла")
    public void ввестиВПоисковуюСтрокуНазваниеГорода(String cityNameFromPropertyFile) {
        String cityName = loadProperty(cityNameFromPropertyFile);
        mainPage.enterDataToTheSearchContainer(cityName);
    }

    @And("Нажать на кнопку поиска")
    public void нажатьНаКнопкуПоиска() {
        mainPage.clickOnTheSearchButton();
    }

    @And("Выбрать {int} город в результате поиска")
    public void выбратьГородВРезультатеПоиска(int cityNumber) {
        mainPage.selectCityFromTheDropDown(cityNumber);
    }

    @Then("Отображается информация о погоде для выбранного города {string}")
    public void отображаетсяИнформацияОПогодеДляВыбранногоГорода(String cityName) {
        Assertions.assertTrue(mainPage.getSelectedCity().contains(loadProperty(cityName)), "Информация о городе не соответствует");
    }

    @When("Нажать на кнопку SignIn на главной странице сайта")
    public void нажатьНаКнопкуSignInНаГлавнойСтраницеСайта() {
        mainPage.clickOnSignInButton();
    }

    @And("Страница SignIn загрузилась")
    public void страницаSignInЗагрузилась() {
        signInPage.signInPageIsLoaded();
    }

    @And("Нажать на кнопку Create an Account")
    public void нажатьНаКнопкуCreateAnAccount() {
        signInPage.openSignUpPage();
    }

    @And("Страница SignUp загрузилась")
    public void страницаSignUpЗагрузилась() {
        signUpPage.signUpPageIsLoaded();
    }

    @And("Найти и заполнить поле Username со случайно сгенерированным именем")
    public void найтиИЗаполнитьПолеUsernameСоСлучайноСгенерированнымИменем() {
        String selectedUsername = dataGenerator.getUsername();
        log.info("Selected username is: " + selectedUsername);
        signUpPage.enterUsername(selectedUsername);
    }

    @And("Найти и заполнить поле Email со случайно сгенерированным адресом электронной почты")
    public void найтиИЗаполнитьПолеEmailСоСлучайноСгенерированнымАдресомЭлектроннойПочты() {
        String selectedEmail = dataGenerator.getEmail();
        log.info("Selected email is: " + selectedEmail);
        signUpPage.enterEmail(selectedEmail);
    }

        @And("Найти и заполнить поле Пароль со случайно сгенерированным паролем")
    public void найтиИЗаполнитьПолеПарольСоСлучайноСгенерированнымПаролем() {
        signUpPage.enterPassword(GENERATED_PASSWORD);
    }

    @And("Найти и заполнить поле Подтверждение пароля со сгенерированным паролем")
    public void найтиИЗаполнитьПолеПодтверждениеПароляСоСгенерированнымПаролем() {
        signUpPage.enterPasswordConfirmation(GENERATED_PASSWORD);
    }

    @And("Выбрать чекбокс подтверждения возраста")
    public void выбратьЧекбоксПодтвержденияВозраста() {
        signUpPage.selectAgeConfirmationCheckbox();
    }

    @And("Выбрать чекбокс подтверждения принятия политики использования")
    public void выбратьЧекбоксПодтвержденияПринятияПолитикиИспользования() {
     signUpPage.selectAgreementPrivacyPolicyCheckbox();   
    }

    @And("Кликнуть «Я не робот»")
    public void кликнутьЯНеРобот() {
        signUpPage.selectCaptchaCheckbox();
    }

    @And("Найти и нажать кнопку Create Account")
    public void найтиИНажатьКнопкуCreateAccount() {
        signUpPage.clickOnCreateAccountButton();
    }

    @And("Нажать на кнопку Подтвердить")
    public void нажатьНаКнопкуПодтвердить() {
        signUpPage.clickOnAcceptCaptchaButton();
    }

    @And("Нажать на кнопку Create Account")
    public void нажатьНаКнопкуCreateAccount() {
        signUpPage.clickOnTheCreateAccountButton();
    }

    @Then("Попап question block отображается на странице")
    public void попапQuestionBlockОтображаетсяНаСтранице() {
        questionBlock.questionBlockIsLoaded();
    }
}
