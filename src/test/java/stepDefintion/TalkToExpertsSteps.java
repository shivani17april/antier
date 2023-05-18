package stepDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TalkToExpertsPage;
import util.Const;

import static support.FileUtilities.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static support.FileUtilities.readProperty;

public class TalkToExpertsSteps extends TalkToExpertsPage {
    String PROPERTY_FILE_NAME = "config";
    HomePage homePage = new HomePage();
    WebDriver driver;

    @Given("The user launches the applications")
    public void theUserLaunchesTheApplication() {
        String appURL = Const.Config.app_url;// readProperty(PROPERTY_FILE_NAME, "app_url");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.body.style.zoom='80%'");
        this.driver = homePage.launchApplication(appURL);

    }

    @When("The user click on Talk to our experts links")
    public void the_user_click_on_link() {
        homePage.talktoExp(driver);
    }

//    @Then("The user should be redirected to the Talk to expert Pages")
//    public void userNavigatesToContactusPage() {
//        String expectedTitle = readProperty("talktoexperts", "TalktoexpertPage");
//        String actualTitle = isContactUsTitleAvailable(driver);
//        Assert.assertEquals(actualTitle, expectedTitle);
//    }

    @And("The user enter the names")
    public void userEnterName() {
        try {
            String your_name =  Const.TalkToExpert.yourName;//readProperty("talktoexperts", "yourName");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            enterName(driver, your_name);
        } catch (Exception e) {
            System.out.println("TAG..." + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    @And("The user enters the emails")
    public void userEmail() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String email =Const.TalkToExpert.YourEmail;// readProperty("talktoexperts", "YourEmail");
        enterEmail(driver, email);
    }

    @And("The user enters the countrys")
    public void userEnterTheCountry() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String countryName = Const.TalkToExpert.countryName;//readProperty("talktoexperts", "countryName");
        String countryCode = Const.TalkToExpert.countryCode;//readProperty("talktoexperts", "countryCode");

        enterCountry(driver, countryCode, countryName);
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @And("The user enters the phone numbers")
    public void userPhone() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String phone = Const.TalkToExpert.yourPhone;//readProperty("talktoexperts", "yourPhone");
        enterPhone(driver, phone);
    }

    @And("The user enters the Messages")
    public void message() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String msg =Const.TalkToExpert.YourMessage;// readProperty("talktoexperts", "YourMessage");
        enterMsg(driver, msg);
    }

    @And("The user verify captchas")
    public void captcha() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        verifyCaptcha(driver);
    }

    @And("The user submit the form datas")
    public void Submit() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,550)", "");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        clickOnContactSubmit(driver);
    }

    @And("The user redirected to the Thanks Pages")
    public void Success() {
        success(driver);
    }


}
