package stepDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;

import util.Const;

import static support.FileUtilities.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static support.FileUtilities.readProperty;

public class ContactUsSteps extends ContactUsPage {
    String PROPERTY_FILE_NAME = "config";
    HomePage homePage = new HomePage();
    WebDriver driver;

    @Given("The user launches the application")
    public void theUserLaunchesTheApplication() {
        String appURL = Const.Config.app_url;//readProperty(PROPERTY_FILE_NAME, "app_url");
        this.driver = homePage.launchApplication(appURL);
    }

    @When("The user click on Contact Us link")
    public void the_user_click_on_link() {
        homePage.clickOnContactUsLink(driver);
    }

    @Then("The user should be redirected to the contact us Page")
    public void userNavigatesToContactusPage() {
        try {
            String expectedTitle = Const.ContactUs.contactUsPageTitle;//readProperty("contactus", "contactUsPageTitle");
            String actualTitle = isContactUsTitleAvailable(driver);
            // Assert.assertEquals(actualTitle, expectedTitle);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    @When("The user enters the name")
    public void userEnterName() {
        String your_name = Const.ContactUs.yourName;//readProperty("contactus", "yourName");
        enterName(driver, your_name);
    }


    @And("The user enters the country")
    public void userEnterTheCountry() {
        String countryName = Const.ContactUs.countryName;//readProperty("contactus", "countryName");
        String countryCode = Const.ContactUs.countryCode;//readProperty("contactus", "countryCode");
        enterCountry(driver, countryCode, countryName);
    }

    @And("The user enters the email")
    public void userEmail() {
        String email = Const.ContactUs.yourEmail;// readProperty("contactus", "YourEmail");
        enterEmail(driver, email);
    }

    @And("The user enters the phone number")
    public void userPhone() {
        String phone = Const.ContactUs.yourPhone;//readProperty("contactus", "yourPhone");
        enterPhone(driver, phone);
    }

    @And("The user enters the Message")
    public void message() {
        String msg = Const.ContactUs.YourMessage;//readProperty("contactus", "YourMessage");
        enterMsg(driver, msg);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @And("The user verify captcha")
    public void captcha() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        verifyCaptcha(driver);
    }

    @And("The user submit the form data")
    public void Submit() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        clickOnContactSubmit(driver);

    }

    @And("The user redirected to the Thanks Page")
    public void Success() {
        success(driver);
    }


}
