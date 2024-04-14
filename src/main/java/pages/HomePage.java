package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utili.CustomMethods.*;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver = driver;
    }


    private final By regButton = By.xpath("//a[@href='/register?returnUrl=%2F']");
    private final By logInButton = By.xpath("//a[@href='/login?returnUrl=%2F']");
    private final By alertMsgForLogin =By.xpath("//a[@class='ico-account']");


    private final By logoutButton = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");



    @Step
    public RegistrationPage clickRegistrationForm(){

        findElementClickable(driver,regButton).click();
        return new RegistrationPage(driver);
    }

    @Step
    public LoginPage clickLoginForm(){

        findElementClickable(driver,logInButton).click();
        return new LoginPage(driver);
    }


    @Step
    public String getAlertForLogin(){

        return findElementPresence(driver,alertMsgForLogin).getText();
    }

    @Step
    public HomePage clickLogoutButton(){

        findElementClickable(driver , logoutButton).click();
        return new HomePage(driver);

    }











    public HomePage registerScenario(String firstName, String lastName, String birthDay, String birthMonth, String birthYear,
                                     String email, String password){
        clickRegistrationForm()
                .clickGenderRadioBtn()
                .enterFirstAndLastName(firstName, lastName)
                .selectDateOfBirth(birthDay, birthMonth, birthYear)
                .enterEmail(email)
                .enterPassAndConfirmPass(password, password)
                .saveRegistrationData()
                .clickContinue();

        return this;
    }



    public HomePage loginScenario(String email, String password){
        clickLoginForm()
                .enterLoginEmail(email)
                .enterLoginPassword(password)
                .confirmLogin();

        return this;
    }


    public HomePage logoutScenario(){
        clickLogoutButton();
        return this;
    }





}