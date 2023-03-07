package stepDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TalkToExpertsPage;

import static support.FileUtilities.*;

import java.io.File;

import static support.FileUtilities.readProperty;

public class TalkToExpertsSteps extends TalkToExpertsPage {
    String PROPERTY_FILE_NAME = "config";
    HomePage homePage = new HomePage();
    WebDriver driver;

    @Given("The user launches the applications")
    public void theUserLaunchesTheApplication() {
        String appURL = readProperty(PROPERTY_FILE_NAME, "app_url");
        this.driver = homePage.launchApplication(appURL);
    }

    @When("The user click on Talk to our experts links")
    public void the_user_click_on_link() {
        homePage.talktoExp(driver);
    }

    @Then("The user should be redirected to the Talk to expert Pages")
    public void userNavigatesToContactusPage() {
        String expectedTitle = readProperty("talktoexperts", "TalktoexpertPage");
        String actualTitle = isContactUsTitleAvailable(driver);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("The user enters the names")
    public void userEnterName() {
        String your_name = readProperty("talktoexperts", "yourName");
        enterName(driver, your_name);
    }


    @And("The user enters the countrys")
    public void userEnterTheCountry() {
        String countryName = readProperty("talktoexperts", "countryName");
        String countryCode = readProperty("talktoexperts", "countryCode");
        enterCountry(driver, countryCode, countryName);
    }

    @And("The user enters the emails")
    public void userEmail() {
        String email = readProperty("talktoexperts", "YourEmail");
        enterEmail(driver, email);
    }

    @And("The user enters the phone numbers")
    public void userPhone() {
        String phone = readProperty("talktoexperts", "yourPhone");
        enterPhone(driver, phone);
    }

    @And("The user enters the Messages")
    public void message() {
        String msg = readProperty("talktoexperts", "YourMessage");
        enterMsg(driver, msg);
    }

    @And("The user submit the form datas")
    public void Submit() {
        clickOnContactSubmit(driver);

    }


}
