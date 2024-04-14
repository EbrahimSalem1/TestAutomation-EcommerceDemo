package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class TestBase {

    WebDriver driver;
    protected HomePage homePage;


    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }


    @BeforeMethod
    public void setUp(){



        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");

        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }



}