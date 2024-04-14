package utili;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CustomMethods {


    public static WebElement findElementPresence(WebDriver driver , By by){
        var wait = new FluentWait<>(driver).withTimeout(Duration.ofMillis(15000)).pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement findElementClickable(WebDriver driver , By by){
        var wait = new FluentWait<>(driver).withTimeout(Duration.ofMillis(15000)).pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }


}
