package login;

import base.TestBase;
import base.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import static utilities.DataDrivenClass.JsonClass.readJson;

@Listeners(TestListeners.class)
public class LoginTests extends TestBase {


    String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\LoginData.json";

    @Test
    public void testValidLoginAndLogout(){
        Assert.assertTrue(
                homePage.clickLoginForm()
                        .enterLoginEmail(readJson(jsonFilePath,"email1"))
                        .enterLoginPassword(readJson(jsonFilePath,"password1"))
                        .confirmLogin()
                        .getAlertForLogin().contains("My account"), "login unsuccessful"



        );


        Assert.assertFalse(homePage.clickLogoutButton().equals("Register"));
//        homePage.clickLogoutButton();




    }




    //    @Test(priority = 2)
//    public void testLogout(){
//
//        homePage.clickLogoutButton();
//
//    }





}