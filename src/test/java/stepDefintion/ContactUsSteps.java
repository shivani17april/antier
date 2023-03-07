package stepDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import sendEmail.SendEmail;

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
        String appURL = readProperty(PROPERTY_FILE_NAME, "app_url");
        this.driver = homePage.launchApplication(appURL);
    }

    @When("The user click on Contact Us link")
    public void the_user_click_on_link() {
        homePage.clickOnContactUsLink(driver);
    }

    @Then("The user should be redirected to the contact us Page")
    public void userNavigatesToContactusPage() {
        String expectedTitle = readProperty("contactus", "contactUsPageTitle");
        String actualTitle = isContactUsTitleAvailable(driver);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("The user enters the name")
    public void userEnterName() {
        String your_name = readProperty("contactus", "yourName");
        enterName(driver, your_name);
    }


    @And("The user enters the country")
    public void userEnterTheCountry() {
        String countryName = readProperty("contactus", "countryName");
        String countryCode = readProperty("contactus", "countryCode");
        enterCountry(driver, countryCode, countryName);
    }

    @And("The user enters the email")
    public void userEmail() {
        String email = readProperty("contactus", "YourEmail");
        enterEmail(driver, email);
    }

    @And("The user enters the phone number")
    public void userPhone() {
        String phone = readProperty("contactus", "yourPhone");
        enterPhone(driver, phone);
    }

    @And("The user enters the Message")
    public void message() {
        String msg = readProperty("contactus", "YourMessage");
        enterMsg(driver, msg);
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("The user submit the form data")
    public void Submit() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        clickOnContactSubmit(driver);

       SendEmail email=new SendEmail();
       email.sendEmailFxn("ds","dsd");

    }


}
