package stepDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import static support.FileUtilities.*;


public class LoginSteps extends LoginPage {

    String PROPERTY_FILE_NAME= "config";

    @Given("The user launches the application")
    public void theUserLaunchesTheApplication(){
        String appURL= readProperty(PROPERTY_FILE_NAME,"app_url");
        userLaunchWebApplication(appURL);
    }

    @When("The user enters the username and password")
    public void userEntersTheUsernameAndPassword(){
        String username= readProperty(PROPERTY_FILE_NAME,"username");
        String password= readProperty(PROPERTY_FILE_NAME,"password");
        submitUserName(username);
        submitPassword(password);
    }

    @When("The user click on Contact Us link")
    public void the_user_click_on_link( ) {
        clickOnContactUsLink();

    }



}
