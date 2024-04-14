package registration;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.DataDrivenClass.JsonClass.readJson;

public class RegistrationTests extends TestBase {

    String jsonFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\RegistrationData.json";


    @Test
    public void testValidRegistration(){
        Assert.assertTrue(
                homePage.clickRegistrationForm()
                        .clickGenderRadioBtn()
                        .enterFirstAndLastName(readJson(jsonFilePath , "first name1")
                                ,readJson(jsonFilePath , "last name1"))
                        .selectDateOfBirth(readJson(jsonFilePath,"day1"),readJson(jsonFilePath,"month1")
                                ,readJson(jsonFilePath,"year1"))
                        .enterEmail(readJson(jsonFilePath,"email1"))
                        .enterPassAndConfirmPass(readJson(jsonFilePath,"password1"), readJson(jsonFilePath,"confPassword1"))
                        .saveRegistrationData()
                        .getAlertText().contains("complete"),"registration Unsuccessful"
        );


    }

}