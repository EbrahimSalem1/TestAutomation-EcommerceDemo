package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utili.CustomMethods.*;

public class RegisterConfirmPage {

    private WebDriver driver;

    public RegisterConfirmPage(WebDriver driver){
        this.driver = driver;
    }


    private final By registerSuccessfulMessage = By.xpath("//div[@class='result']");
    private final By continueBtn = By.xpath("//a[@class='button-1 register-continue-button']");


    @Step
    public final String getAlertText(){
        return findElementPresence(driver,registerSuccessfulMessage).getText();
    }

    @Step
    public HomePage clickContinue(){
        findElementClickable(driver,continueBtn).click();
        return new HomePage(driver);
    }



}
